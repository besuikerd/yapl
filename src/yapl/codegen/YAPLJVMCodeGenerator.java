package yapl.codegen;
import java.util.List;
import java.util.stream.Collectors;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import yapl.context.ConstantExpression.ConstantType;
import yapl.syntax.YAPLBaseVisitor;
import yapl.syntax.YAPLLexer;
import yapl.syntax.YAPLParser.AndExprContext;
import yapl.syntax.YAPLParser.CompareExprContext;
import yapl.syntax.YAPLParser.DeclConstContext;
import yapl.syntax.YAPLParser.DeclVarContext;
import yapl.syntax.YAPLParser.ExpressionContext;
import yapl.syntax.YAPLParser.IdContext;
import yapl.syntax.YAPLParser.MultDivModExprContext;
import yapl.syntax.YAPLParser.OpFalseContext;
import yapl.syntax.YAPLParser.OpIdOrFuncContext;
import yapl.syntax.YAPLParser.OpNumberContext;
import yapl.syntax.YAPLParser.OpParenExprContext;
import yapl.syntax.YAPLParser.OpTrueContext;
import yapl.syntax.YAPLParser.OrExprContext;
import yapl.syntax.YAPLParser.PlusMinusExprContext;
import yapl.syntax.YAPLParser.PrimaryExprContext;
import yapl.syntax.YAPLParser.StatementDeclarationContext;
import yapl.syntax.YAPLParser.StatementExpressionContext;
import yapl.syntax.YAPLParser.YaplContext;
import yapl.tool.ToolContext;
import yapl.typing.Type;
import yapl.utils.STUtils;


public class YAPLJVMCodeGenerator extends YAPLBaseVisitor<ST>{
	
	private STGroup group;
	private ToolContext context;
	private LabelGenerator labelGen;
	
	private static final String LABEL_PREFIX = "LBL";
	
	public YAPLJVMCodeGenerator(STGroup group, ToolContext context) {
		this.group = group;
		this.context = context;
		labelGen = new LabelGenerator(0, LABEL_PREFIX);
	}

	@Override
	public ST visitYapl(YaplContext ctx) {
		
		
		return CodeFunction.yapl.builder()
		.property(CodeProperty.name, context.getOutfileWithoutPath())
		.property(CodeProperty.statements, ctx.statement().stream().map((s) -> s.accept(this)).collect(Collectors.toList()))
		.build(group);
	}
	
	@Override
	public ST visitStatementDeclaration(StatementDeclarationContext ctx) {
		return ctx.declaration().accept(this);
	}
	
	@Override
	public ST visitStatementExpression(StatementExpressionContext ctx) {
		ST loadSysOut = new ST("getstatic java/lang/System/out Ljava/io/PrintStream;\n");
		ST printOut = new ST("invokevirtual java/io/PrintStream/println(I)V");
		return STUtils.concat(loadSysOut, ctx.expression().accept(this), printOut);
	}
	
	@Override
	public ST visitDeclVar(DeclVarContext ctx) {
		ST st =  CodeFunction.declareVariable.builder()
		.property(CodeProperty.constant, STPushConstantForType(ctx.entry.getType()))
		.property(CodeProperty.type, getTypePrefix(ctx.entry.getType()))
		.property(CodeProperty.offset, ctx.entry.getOffset())
		.build(group);
		return st;
	}
	
	@Override
	public ST visitDeclConst(DeclConstContext ctx) {
		ST st = null;
		if(ctx.entry.getConstantExpression().getConstantType() == ConstantType.UNKNOWN_VALUE){
			st = CodeFunction.declareVariable.builder()
			.property(CodeProperty.constant, ctx.expression().accept(this))
			.property(CodeProperty.type, getTypePrefix(ctx.entry.getType()))
			.property(CodeProperty.offset, ctx.entry.getOffset())
			.build(group);
		}
		return st;
	}
	
	@Override
	public ST visitExpression(ExpressionContext ctx) {
		ST st = ctx.orExpr().accept(this);
		if(ctx.EQ() != null){
			IdContext idCtx = ((OpIdOrFuncContext) ctx.orExpr().andExpr(0).compareExpr(0).plusMinusExpr(0).multDivModExpr(0).primaryExpr(0).operand()).id();
			st = CodeFunction.assign.builder()
			.property(CodeProperty.type, getTypePrefix(idCtx.entry.getType()))
			.property(CodeProperty.offset, idCtx.entry.getOffset())
			.property(CodeProperty.expression, ctx.expression().accept(this))
			.build(group);
		}
		return st;
	}
	
	@Override
	public ST visitPrimaryExpr(PrimaryExprContext ctx) {
		ST operand = ctx.operand().accept(this);
		if(ctx.op != null){
			CodeFunction func = null;
			switch(ctx.op.getText()){
			case "-": func = CodeFunction.negate; break;
			case "!": func = CodeFunction.not; break;
			}
			if(func != null){
				ST op = func.toST(group);
				operand = STUtils.concat(operand, op);
			}
		}
		return operand;
	}
	
	@Override
	public ST visitMultDivModExpr(MultDivModExprContext ctx) {
		ST st = ctx.primaryExpr(0).accept(this);
		if(ctx.primaryExpr().size() > 1){
			for(int i = 1 ; i < ctx.primaryExpr().size() ; i++){
				ST op = null;
				String type = "i"; //jvm instruction type
				switch(ctx.opMultDivMod(i - 1).getText()){
					case "*": op = CodeFunction.mult.type(type, group); break;
					case "/": op = CodeFunction.div.type(type, group); break;
					case "%": op = CodeFunction.mod.type(type, group); break;
				}
				st = STUtils.concat(st, ctx.primaryExpr(i).accept(this), op);
			}
		}
		return st;
	}
	
	@Override
	public ST visitPlusMinusExpr(PlusMinusExprContext ctx) {
		ST st = ctx.multDivModExpr(0).accept(this);
		if(ctx.multDivModExpr().size() > 1){
			
			for(int i = 1 ; i < ctx.multDivModExpr().size() ; i++){
				
				ST op = null;
				String type = "i"; //jvm instruction type
				
				switch(ctx.opPlusMinus().get(i - 1).getText()){
				case "+": op = CodeFunction.add.type(type, group); break;
				case "-": op = CodeFunction.sub.type(type, group); break;
				}
				st = STUtils.concat(st, ctx.multDivModExpr(i).accept(this), op);
			}
		}
		return st;
	}
	
	@Override
	public ST visitCompareExpr(CompareExprContext ctx) {
		ST st = ctx.plusMinusExpr(0).accept(this);
		if(ctx.plusMinusExpr().size() > 1){
			for(int i = 1 ; i < ctx.plusMinusExpr().size() ; i++){
				CodeFunction func = null;
				switch(ctx.opCompare(i - 1).getText()){
				case ">": func = CodeFunction.gt; break;
				case ">=": func = CodeFunction.gte; break;
				case "<": func = CodeFunction.lt; break;
				case "<=": func = CodeFunction.lte; break;
				case "==": func = CodeFunction.eq; break;
				case "!=": func = CodeFunction.neq; break;
				
				}
				ST op = func.builder()
				.property(CodeProperty.labelto, labelGen.generate())
				.property(CodeProperty.labelgoto, labelGen.generate())
				.build(group);
				st = STUtils.concat(st, ctx.plusMinusExpr(i).accept(this), op);
			}
		}
		return st;
	}
	
	@Override
	public ST visitAndExpr(AndExprContext ctx) {
		ST st = ctx.compareExpr(0).accept(this);
		if(ctx.compareExpr().size() > 1){
			for(CompareExprContext exprCtx : ctx.compareExpr().subList(1, ctx.compareExpr().size())) {
				st = CodeFunction.and.builder()
				.property(CodeProperty.left, st)
				.property(CodeProperty.right, exprCtx.accept(this))
				.property(CodeProperty.labelto, labelGen.generate())
				.property(CodeProperty.labelto2, labelGen.generate())
				.property(CodeProperty.labelgoto, labelGen.generate())
				.build(group);
			}
		}
		return st;
	}
	
	@Override
	public ST visitOrExpr(OrExprContext ctx) {
		ST st = ctx.andExpr(0).accept(this);
		if(ctx.andExpr().size() > 1){
			for(AndExprContext exprCtx : ctx.andExpr().subList(1, ctx.andExpr().size())){
				st = CodeFunction.or.builder()
				.property(CodeProperty.left, st)
				.property(CodeProperty.right, exprCtx.accept(this))
				.property(CodeProperty.labelto, labelGen.generate())
				.property(CodeProperty.labelto2, labelGen.generate())
				.property(CodeProperty.labelgoto, labelGen.generate())
				.build(group);
			}
		}
		return st;
	}
	
	@Override
	public ST visitOpNumber(OpNumberContext ctx) {
		return CodeFunction.number.builder()
		.property(CodeProperty.num, ctx.number().getText())
		.build(group);
	}
	
	@Override
	public ST visitOpIdOrFunc(OpIdOrFuncContext ctx) {
		
		ST st = null;
		if(ctx.LPAREN() == null){ //an id operand
			IdContext idContext = ctx.id();
			
			switch(idContext.entry.getEntryType()){
			case CONSTANT:
				switch(idContext.entry.getConstantExpression().getConstantType()){
				case KNOWN_VALUE:
					st = CodeFunction.number.builder()
					.property(CodeProperty.num, idContext.entry.getConstantExpression().getValue())
					.build(group);
					break;
					
				case UNKNOWN_VALUE:
					st = CodeFunction.opId.builder()
					.property(CodeProperty.type, getTypePrefix(idContext.entry.getType()))
					.property(CodeProperty.offset, idContext.entry.getOffset())
					.build(group);
					break;
				}
				break;
			case VARIABLE:
				st = CodeFunction.opId.builder()
				.property(CodeProperty.type, getTypePrefix(idContext.entry.getType()))
				.property(CodeProperty.offset, idContext.entry.getOffset())
				.build(group);
				break;
			}
			
			
		} else { //TODO funcion operand
			
		}
		return st;
	}
	
	@Override
	public ST visitOpParenExpr(OpParenExprContext ctx) {
		return ctx.expression().accept(this);
	}
	
	@Override
	public ST visitOpTrue(OpTrueContext ctx) {
		return CodeFunction.optrue.toST(group);
	}
	
	@Override
	public ST visitOpFalse(OpFalseContext ctx) {
		return CodeFunction.opfalse.toST(group);
	}
		
	private String getTypePrefix(Type t){
		String type = "a";
		if(t != null){
			switch(t.getKind()){
			case INTEGER: 
			case BOOLEAN: 
			case CHAR:
				type = "i";
				break;
			default:      
				type = "a";
				break;
			}
		}
		return type;
	}
	
	private ST STPushConstantForType(Type t){
		ST st = null;
		if(t != null){
			switch(t.getKind()){
			case INTEGER:
			case BOOLEAN:
			case CHAR:
				st = new ST("iconst_0");
				break;
			}
		}
		return st;
	}
}