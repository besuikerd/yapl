package yapl.context;

import java.util.ArrayList;
import java.util.List;

import yapl.context.IdEntry.EntryType;
import yapl.reporter.ErrorReporter;
import yapl.syntax.YAPLBaseVisitor;
import yapl.syntax.YAPLLexer;
import yapl.syntax.YAPLParser;
import yapl.syntax.YAPLParser.AndExprContext;
import yapl.syntax.YAPLParser.CompareExprContext;
import yapl.syntax.YAPLParser.DeclConstContext;
import yapl.syntax.YAPLParser.DeclVarContext;
import yapl.syntax.YAPLParser.ExprBlockContext;
import yapl.syntax.YAPLParser.ExpressionContext;
import yapl.syntax.YAPLParser.IdContext;
import yapl.syntax.YAPLParser.MultDivModExprContext;
import yapl.syntax.YAPLParser.NumberContext;
import yapl.syntax.YAPLParser.OpExprBlockContext;
import yapl.syntax.YAPLParser.OpIdOrFuncContext;
import yapl.syntax.YAPLParser.OpIfThenElseContext;
import yapl.syntax.YAPLParser.OpWhileContext;
import yapl.syntax.YAPLParser.OrExprContext;
import yapl.syntax.YAPLParser.PlusMinusExprContext;
import yapl.syntax.YAPLParser.PrimaryExprContext;
import yapl.syntax.YAPLParser.YaplContext;
import yapl.typing.Type;

/**
 * The context checker of YAPL that checks the contextual constraints of the
 * language.
 * @author Nicker
 *
 */
public class YAPLChecker extends YAPLBaseVisitor<Void>{
	
	/**
	 * SymbolTable to store id declarations in 
	 */
	protected SymbolTable<IdEntry> symbolTable;
	
	/**
	 * reporter to report contextual errors to
	 */
	protected ErrorReporter reporter;
	
	/**
	 * Visitor class that can determine the type of an expression
	 */
	protected YAPLTypeVisitor typeVisitor;
	
	/**
	 * Visitor class that can determine the {@link ConstantExpression} value of
	 * an expression
	 */
	protected ConstantExpressionVisitor constantVisitor;
	
	/**
	 * Visitor class that can check if an expression is an Identifier
	 * (variable or constant) expression
	 */
	protected IsIdentifierVisitor isIdentifierVisitor;
	
	/**
	 * Constructs a new YAPL Context checker
	 * @param symbolTable SymbolTable to store declarations in
	 * @param typeVisitor visitor to visit types with
	 * @param reporter ErrorReporter to report errors to
	 */
	public YAPLChecker(SymbolTable<IdEntry> symbolTable, YAPLTypeVisitor typeVisitor, ErrorReporter reporter) {
		this.symbolTable = symbolTable;
		this.reporter = reporter;
		this.typeVisitor = typeVisitor;
		this.constantVisitor = new ConstantExpressionVisitor();
		this.isIdentifierVisitor = new IsIdentifierVisitor();
	}

	@Override
	public Void visitYapl(YaplContext ctx) {
		symbolTable.openScope();
		super.visitYapl(ctx);
		symbolTable.closeScope().forEach((entry) ->{
			if(!entry.isUsed()){
				reporter.context().warnUnusedVariable(entry);
			}
		});
		return null;
	}
	
	@Override
	public Void visitDeclVar(DeclVarContext ctx) {
		List<IdEntry> entries = new ArrayList<IdEntry>();
		for(IdContext id : ctx.id()){
			IdEntry entry = new IdEntry(id.getText(), ctx, ctx.typeDenoter().accept(typeVisitor), EntryType.VARIABLE);
			try {
				symbolTable.enter(id.getText(), entry);
			} catch(SymbolTableException e){
				reporter.context().error(id.start, e.getMessage());
			}
			entries.add(entry);
			id.entry = entry;
		}
		ctx.entries = entries;
		return null;
	}
	
	@Override
	public Void visitDeclConst(DeclConstContext ctx) {
		List<IdEntry> entries = new ArrayList<IdEntry>();
		ctx.expression().accept(this);
		for(IdContext id : ctx.id()){
			IdEntry entry = new IdEntry(id.getText(), ctx, ctx.expression().accept(typeVisitor), EntryType.CONSTANT);
			entry.setConstantExpression(ctx.expression().accept(constantVisitor));
			try{
				symbolTable.enter(id.getText(), entry);
			} catch(SymbolTableException e){
				reporter.context().error(id.start, e.getMessage());
			}
			id.entry = entry;
		}
		ctx.entries = entries;
		return null;
	}
	
	@Override
	public Void visitExpression(ExpressionContext ctx) {
		super.visitExpression(ctx);
		Type orType = ctx.orExpr().accept(typeVisitor);
		ctx.type = orType;
		if(ctx.EQ() != null){ //an assign expression
			boolean isId = ctx.orExpr().accept(isIdentifierVisitor);
			if(isId){
				Type exprType = ctx.expression().accept(typeVisitor);
				Type idType = orType;
				if(!idType.matchesType(exprType)){
					reporter.context().errorInvalidAssignmentType(ctx.expression(), idType, exprType);
				}
			} else{
				reporter.context().errorLHSNotIdentifier(ctx.orExpr());
			}
		}
		return null;
	}
	
	@Override
	public Void visitOpExprBlock(OpExprBlockContext ctx) {
		return ctx.exprBlock().accept(this);
	}
	
	@Override
	public Void visitExprBlock(ExprBlockContext ctx) {
		symbolTable.openScope();
		ctx.statement().forEach((statement) -> statement.accept(this));
		if(ctx.expression() != null){
			ctx.expression().accept(this);
		}
		symbolTable.closeScope().forEach((entry) ->{
			if(!entry.isUsed()){
				reporter.context().warnUnusedVariable(entry);
			}
		});
		return null;
	}
	
	@Override
	public Void visitOpIfThenElse(OpIfThenElseContext ctx) {
		ctx.expression().forEach((expression) -> expression.accept(this));
		Type typeConditional = ctx.expression(0).accept(typeVisitor);
		if(!typeConditional.matchesType(Type.BOOLEAN)){
			reporter.context().errorUnexpectedType(ctx, Type.BOOLEAN, typeConditional);
		}
		if(ctx.expression().size() == 3){
			Type typeTrue = ctx.expression(1).accept(typeVisitor);
			Type typeFalse = ctx.expression(2).accept(typeVisitor);
			if(!typeTrue.matchesType(typeFalse)){
				reporter.context().errorIfElseType(ctx, typeTrue, typeFalse);
			}
		}
		return null;
	}
	
	@Override
	public Void visitOpWhile(OpWhileContext ctx) {
		ctx.expression().accept(this);
		ctx.exprBlock().accept(this);
		Type typeConditional = ctx.expression().accept(typeVisitor);
		if(!typeConditional.matchesType(Type.BOOLEAN)){
			reporter.context().errorUnexpectedType(ctx, Type.BOOLEAN, typeConditional);
		}
		return null;
	}

	@Override
	public Void visitNumber(NumberContext ctx) {
		return super.visitNumber(ctx);
	}
	
	@Override
	public Void visitId(IdContext ctx) {
		IdEntry entry = symbolTable.retrieve(ctx.getText());
		if(entry == null){
			reporter.context().error(ctx.start, "unknown variable: %s", ctx.getText());
		} else{
			ctx.entry = entry;
		}
		return null;
	}
	
	@Override
	public Void visitPrimaryExpr(PrimaryExprContext ctx) {
		super.visitPrimaryExpr(ctx);
		if(ctx.op != null){
			Type type = ctx.operand().accept(typeVisitor);
			switch(ctx.op.getType()){
			case YAPLLexer.LNOT:
				if(!type.matchesType(Type.BOOLEAN)) reporter.context().errorBinaryOpType(ctx.operand(), ctx.op.getText(), Type.BOOLEAN, type);
				break;
			case YAPLLexer.MINUS:
			case YAPLLexer.PLUS:
				if(!type.matchesType(Type.INT)) reporter.context().errorBinaryOpType(ctx.operand(), ctx.op.getText(), Type.INT, type);
				break;
			}
		}
		return null;
	}
	
	@Override
	public Void visitMultDivModExpr(MultDivModExprContext ctx) {
		super.visitMultDivModExpr(ctx);
		for(int i = 1 ; i < ctx.primaryExpr().size() ; i++){
			PrimaryExprContext ctxLeft = ctx.primaryExpr(i - 1);
			PrimaryExprContext ctxRight = ctx.primaryExpr(i);
			Type left = ctxLeft.accept(typeVisitor);
			Type right = ctxLeft.accept(typeVisitor);
			if(!left.matchesType(Type.INT)) reporter.context().errorBinaryOpType(ctxLeft, ctx.opMultDivMod(i - 1).getText(), Type.INT, left);
			if(!right.matchesType(Type.INT)) reporter.context().errorBinaryOpType(ctxRight, ctx.opMultDivMod(i - 1).getText(), Type.INT, right);
		}
		return null;
	}
	
	@Override
	public Void visitPlusMinusExpr(PlusMinusExprContext ctx) {
		super.visitPlusMinusExpr(ctx);
			for(int i = 1 ; i < ctx.multDivModExpr().size() ; i++){
				MultDivModExprContext ctxLeft = ctx.multDivModExpr(i - 1);
				MultDivModExprContext ctxRight = ctx.multDivModExpr(i);
				Type left = ctxLeft.accept(typeVisitor);
				Type right = ctxRight.accept(typeVisitor);
				if(!left.matchesType(Type.INT)) reporter.context().errorBinaryOpType(ctxLeft, ctx.opPlusMinus(i - 1).getText(), Type.INT, left);
				if(!right.matchesType(Type.INT)) reporter.context().errorBinaryOpType(ctxRight, ctx.opPlusMinus(i - 1).getText(), Type.INT, right);
			}
				
		return null;
	}
	
	@Override
	public Void visitCompareExpr(CompareExprContext ctx) {
		super.visitCompareExpr(ctx);
		for(int i = 1 ; i < ctx.plusMinusExpr().size() ; i++){
			PlusMinusExprContext ctxLeft = ctx.plusMinusExpr(i - 1);
			PlusMinusExprContext ctxRight = ctx.plusMinusExpr(i);
			Type left = ctxLeft.accept(typeVisitor);
			Type right = ctxRight.accept(typeVisitor);
			if(!left.matchesType(right)) reporter.context().errorBinaryOpType(ctxRight, ctx.opCompare(i - 1).getText(), left, right);
		}
		return null;
	}
	
	@Override
	public Void visitAndExpr(AndExprContext ctx) {
		super.visitAndExpr(ctx);
		for(int i = 1 ; i < ctx.compareExpr().size() ; i++){
			CompareExprContext ctxLeft = ctx.compareExpr(i - 1);
			CompareExprContext ctxRight = ctx.compareExpr(i);
			Type left = ctxLeft.accept(typeVisitor);
			Type right = ctxRight.accept(typeVisitor);
			if(!left.matchesType(Type.BOOLEAN)) reporter.context().errorBinaryOpType(ctxLeft, ctx.getToken(YAPLParser.LAND, i), Type.BOOLEAN, left);
			if(!right.matchesType(Type.BOOLEAN)) reporter.context().errorBinaryOpType(ctxRight, ctx.getToken(YAPLParser.LAND, i), Type.BOOLEAN, right);
		}
		return null;
	}
	
	@Override
	public Void visitOrExpr(OrExprContext ctx) {
		super.visitOrExpr(ctx);
		for(int i = 1 ; i < ctx.andExpr().size() ; i++){
			AndExprContext ctxLeft = ctx.andExpr(i - 1);
			AndExprContext ctxRight = ctx.andExpr(i);
			Type left = ctxLeft.accept(typeVisitor);
			Type right = ctxRight.accept(typeVisitor);
			if(!left.matchesType(Type.BOOLEAN)) reporter.context().errorBinaryOpType(ctxLeft, ctx.getToken(YAPLParser.LOR, i), Type.BOOLEAN, left);
			if(!right.matchesType(Type.BOOLEAN)) reporter.context().errorBinaryOpType(ctxRight, ctx.getToken(YAPLParser.LOR, i), Type.BOOLEAN, right);
		}
		return null;
	}
	
	
	@Override
	public Void visitOpIdOrFunc(OpIdOrFuncContext ctx) {
		if(ctx.LPAREN() != null){
			ctx.expression().forEach((expression) -> expression.accept(this));
			
			switch(ctx.id().getText()){
			case "read":
				if(ctx.expression().isEmpty()){
					reporter.context().errorNoFunctionArguments(ctx);
				}
				ctx.expression().forEach((expression) -> {
					if(!expression.accept(isIdentifierVisitor)){
						reporter.context().errorNotIdentifierExpression(expression);
					}
					if(expression.type.matchesType(Type.VOID) || expression.type.matchesType(Type.ERROR)){
						reporter.context().errorInvalidFunctionArgumentType(expression);
					}
				});
				break;
			case "print":
				if(ctx.expression().isEmpty()){
					reporter.context().errorNoFunctionArguments(ctx);
				}
				ctx.expression().forEach((expression) -> {
					if(expression.type.matchesType(Type.VOID) || expression.type.matchesType(Type.ERROR)){
						reporter.context().errorInvalidFunctionArgumentType(expression);
					}
				});
				break;
		    default:
		    	reporter.context().errorUnknownFunction(ctx);
			}
			
			
			return null;
		} else{
			return ctx.id().accept(this);
		}
	}
}