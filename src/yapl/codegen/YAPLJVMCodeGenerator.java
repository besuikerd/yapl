package yapl.codegen;
import java.util.List;
import java.util.stream.Collectors;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import yapl.context.ConstantExpression.ConstantType;
import yapl.context.IdEntry;
import yapl.syntax.YAPLBaseVisitor;
import yapl.syntax.YAPLParser.AndExprContext;
import yapl.syntax.YAPLParser.CompareExprContext;
import yapl.syntax.YAPLParser.DeclConstContext;
import yapl.syntax.YAPLParser.DeclVarContext;
import yapl.syntax.YAPLParser.ExprBlockContext;
import yapl.syntax.YAPLParser.ExpressionContext;
import yapl.syntax.YAPLParser.IdContext;
import yapl.syntax.YAPLParser.MultDivModExprContext;
import yapl.syntax.YAPLParser.OpCharContext;
import yapl.syntax.YAPLParser.OpExprBlockContext;
import yapl.syntax.YAPLParser.OpFalseContext;
import yapl.syntax.YAPLParser.OpIdOrFuncContext;
import yapl.syntax.YAPLParser.OpIfThenElseContext;
import yapl.syntax.YAPLParser.OpNumberContext;
import yapl.syntax.YAPLParser.OpParenExprContext;
import yapl.syntax.YAPLParser.OpTrueContext;
import yapl.syntax.YAPLParser.OpWhileContext;
import yapl.syntax.YAPLParser.OrExprContext;
import yapl.syntax.YAPLParser.PlusMinusExprContext;
import yapl.syntax.YAPLParser.PrimaryExprContext;
import yapl.syntax.YAPLParser.StatementDeclarationContext;
import yapl.syntax.YAPLParser.StatementExpressionContext;
import yapl.syntax.YAPLParser.YaplContext;
import yapl.tool.ToolContext;
import yapl.typing.Type;
import yapl.utils.CharUtils;
import yapl.utils.STUtils;
import yapl.utils.Tuple2;
import yapl.utils.Tuple3;


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
		ST st = ctx.expression().accept(this);
		if(!ctx.expression().type.matchesType(Type.VOID)){
			st = STUtils.concat(st, CodeFunction.pop.toST(group));
		}
		return st;
	}
	
	@Override
	public ST visitDeclVar(DeclVarContext ctx) {
		ST st = new ST("");
		for(IdEntry entry : ctx.entries) {
			st = STUtils.concat(st, 
				CodeFunction.declareVariable.builder()
				.property(CodeProperty.constant, STPushConstantForType(entry.getType()))
				.property(CodeProperty.type, getTypePrefix(entry.getType()))
				.property(CodeProperty.offset, entry.getOffset())
				.build(group)
			);
		}
		return st;
	}
	
	@Override
	public ST visitDeclConst(DeclConstContext ctx) {
		ST st = null;
		if(ctx.id(0).entry.getConstantExpression().getConstantType() == ConstantType.UNKNOWN_VALUE){
			st = ctx.expression().accept(this);
			String typePrefix = getTypePrefix(ctx.expression().type);
			for(int i = 0 ; i < ctx.entries.size() ; i++){
				if(i < ctx.entries.size() - 1){
					st = STUtils.concat(st, CodeFunction.dup.toST(group));
				}
				IdEntry entry = ctx.entries.get(i);
				st = STUtils.concat(st, 
					CodeFunction.store.builder()
					.property(CodeProperty.type, typePrefix)	
					.property(CodeProperty.offset, entry.getOffset())
					.build(group)
				);
			}
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
		return CodeFunction.constant.builder()
		.property(CodeProperty.constant, ctx.number().getText())
		.build(group);
	}
	
	@Override
	public ST visitOpIdOrFunc(OpIdOrFuncContext ctx) {
		IdContext idContext = ctx.id();
		ST st = null;
		if(ctx.LPAREN() == null){ //an id operand
			switch(idContext.entry.getEntryType()){
			case CONSTANT:
				switch(idContext.entry.getConstantExpression().getConstantType()){
				case KNOWN_VALUE:
					st = CodeFunction.constant.builder()
					.property(CodeProperty.constant, idContext.entry.getConstantExpression().getValue())
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
			
			
		} else {
			switch(idContext.getText()){
			case "read":				
				if(ctx.expression().size() == 1){
					ExpressionContext exprCtx = ctx.expression(0);
					idContext = ((OpIdOrFuncContext) exprCtx.orExpr().andExpr(0).compareExpr(0).plusMinusExpr(0).multDivModExpr(0).primaryExpr(0).operand()).id();
					st = CodeFunction.read.builder()
					.property(CodeProperty.name, context.getOutfileWithoutPath())
					.property(CodeProperty.offset, idContext.entry.getOffset())
					.property(CodeProperty.function, getFunctionForType(exprCtx.type))
					.property(CodeProperty.type, getJVMType(exprCtx.type))
					.build(group);
				} else {
					List<Tuple3<String, String, Integer>> tuples = ctx.expression().stream().map((expr) -> {
						IdContext idCtx = ((OpIdOrFuncContext) expr.orExpr().andExpr(0).compareExpr(0).plusMinusExpr(0).multDivModExpr(0).primaryExpr(0).operand()).id();
						return new Tuple3<String, String, Integer>(getFunctionForType(expr.type), getJVMType(expr.type), idCtx.entry.getOffset());
					}).collect(Collectors.toList()); 
					st = CodeFunction.readMultiple.builder()
					.property(CodeProperty.name, context.getOutfileWithoutPath())
					.property(CodeProperty.tuples, tuples)
					.build(group);
				}
				
				
				break;
			case "print":
				if(ctx.expression().size() == 1){
					st = CodeFunction.print.builder()
					.property(CodeProperty.expression, ctx.expression(0).accept(this))
					.property(CodeProperty.type, getJVMType(ctx.expression(0).type))
					.build(group);
				} else if(ctx.expression().size() > 1){
					st = CodeFunction.printMultiple.builder()
					.property(CodeProperty.expressions_types, ctx.expression().stream().map((expr) -> new Tuple2<ST, String>(expr.accept(this), getJVMType(expr.type))).collect(Collectors.toList()))
					.build(group);
				}
				break;
			
			}
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
	
	@Override
	public ST visitOpChar(OpCharContext ctx) {
		
		return CodeFunction.constant.builder()
		.property(CodeProperty.constant, (int) CharUtils.string2Char(ctx.CHARLITERAL().getText()))
		.build(group);
	}
	
	@Override
	public ST visitOpExprBlock(OpExprBlockContext ctx) {
		return ctx.exprBlock().accept(this);
	}
	
	@Override
	public ST visitExprBlock(ExprBlockContext ctx) {
		CodeFunction.Builder builder =  CodeFunction.opExprBlock.builder()
		.property(CodeProperty.statements, ctx.statement().stream().map((statement) -> statement.accept(this)).collect(Collectors.toList()));
		if(ctx.expression() != null){
			builder = builder.property(CodeProperty.expression, ctx.expression().accept(this));
		}
		return builder.build(group);
	}
	
	@Override
	public ST visitOpIfThenElse(OpIfThenElseContext ctx) {
		ST st = null;
		if(ctx.expression().size() == 3){
			st = CodeFunction.opIfThenElse.builder()
			.property(CodeProperty.conditional, ctx.expression(0).accept(this))
			.property(CodeProperty.exprTrue, ctx.expression(1).accept(this))
			.property(CodeProperty.exprFalse, ctx.expression(2).accept(this))
			.property(CodeProperty.labelgoto, labelGen.generate())
			.property(CodeProperty.labelto, labelGen.generate())
			.build(group);
		} else {
			CodeFunction.Builder builder = CodeFunction.opIfThen.builder()
			.property(CodeProperty.conditional, ctx.expression(0).accept(this))
			.property(CodeProperty.exprTrue, ctx.expression(1).accept(this))
			.property(CodeProperty.labelto, labelGen.generate());
			if(ctx.expression(1).type != Type.VOID){
				builder = builder.property(CodeProperty.popmaybe, "pop");
			}
			st = builder.build(group);
		}
		return st;
	}
	
	@Override
	public ST visitOpWhile(OpWhileContext ctx) {
		CodeFunction.Builder builder = CodeFunction.opWhile.builder()
		.property(CodeProperty.conditional, ctx.expression().accept(this))
		.property(CodeProperty.body, ctx.exprBlock().accept(this))
		.property(CodeProperty.labelto, labelGen.generate())
		.property(CodeProperty.labelgoto, labelGen.generate());
		
		if(ctx.exprBlock().expression() != null && !ctx.exprBlock().expression().type.matchesType(Type.VOID)){
			builder = builder
			.property(CodeProperty.popmaybe, "pop");
		}
		return builder.build(group);
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
	
	private String getFunctionForType(Type t){
		String type = "Int";
		if(t != null){
			switch(t.getKind()){
			case INTEGER: type = "Integer"; break;
			case CHAR: type = "Char"; break;
			case BOOLEAN: type = "Boolean"; break;
			}
		}
		return type;
	}
	
	private String getJVMType(Type t){
		String type = "I";
		if(t != null){
			switch(t.getKind()){
			case INTEGER: type = "I"; break;
			case CHAR: type = "C"; break;
			case BOOLEAN: type = "Z"; break;
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