package yapl.context;

import yapl.reporter.ErrorReporter;
import yapl.syntax.YAPLBaseVisitor;
import yapl.syntax.YAPLLexer;
import yapl.syntax.YAPLParser;
import yapl.syntax.YAPLParser.AndExprContext;
import yapl.syntax.YAPLParser.CompareExprContext;
import yapl.syntax.YAPLParser.DeclConstContext;
import yapl.syntax.YAPLParser.DeclVarContext;
import yapl.syntax.YAPLParser.ExpressionContext;
import yapl.syntax.YAPLParser.IdContext;
import yapl.syntax.YAPLParser.MultDivModExprContext;
import yapl.syntax.YAPLParser.NumberContext;
import yapl.syntax.YAPLParser.OpExprBlockContext;
import yapl.syntax.YAPLParser.OpIdOrFuncContext;
import yapl.syntax.YAPLParser.OpNumberContext;
import yapl.syntax.YAPLParser.OrExprContext;
import yapl.syntax.YAPLParser.PlusMinusExprContext;
import yapl.syntax.YAPLParser.PrimaryExprContext;
import yapl.syntax.YAPLParser.YaplContext;
import yapl.typing.Type;

public class YAPLChecker extends YAPLBaseVisitor<Void>{
	
	protected SymbolTable<IdEntry> symbolTable;
	protected ErrorReporter reporter;
	protected YAPLTypeVisitor typeVisitor;
	
	public YAPLChecker(SymbolTable<IdEntry> symbolTable, YAPLTypeVisitor typeVisitor, ErrorReporter reporter) {
		this.symbolTable = symbolTable;
		this.reporter = reporter;
		this.typeVisitor = typeVisitor;
	}

	@Override
	public Void visitYapl(YaplContext ctx) {
		symbolTable.openScope();
		Void v = super.visitYapl(ctx);
		symbolTable.closeScope().forEach((entry) ->{
			if(!entry.isUsed()){
				reporter.context().warnUnusedVariable(entry);
			}
		});
		return v;
	}
	
	@Override
	public Void visitDeclVar(DeclVarContext ctx) {
		IdEntry entry = new IdEntry(ctx.id().getText(), ctx, ctx.typeDenoter().accept(typeVisitor));
		try {
			symbolTable.enter(ctx.id().getText(), entry);
		} catch(SymbolTableException e){
			reporter.context().error(ctx.id().start, e.getMessage());
		}
		
		return ctx.typeDenoter().accept(this);
	}
	
	@Override
	public Void visitDeclConst(DeclConstContext ctx) {
		IdEntry entry = new IdEntry(ctx.id().getText(), ctx, ctx.expression().accept(typeVisitor));
		try{
			symbolTable.enter(ctx.id().getText(), entry);
		} catch(SymbolTableException e){
			reporter.context().error(ctx.id().start, e.getMessage());
		}
		return ctx.expression().accept(this);
	}
	
	@Override
	public Void visitExpression(ExpressionContext ctx) {
		Void v = super.visitExpression(ctx);
		if(ctx.EQ() != null){ //an assign expression

			//TODO maybe find another way to ensure it is an identifier
			boolean isId = ctx.orExpr().start == ctx.orExpr().stop && ctx.orExpr().start.getType() == YAPLParser.IDENTIFIER;
			if(isId){
				Type idType = ctx.orExpr().accept(typeVisitor);
				Type exprType = ctx.expression().accept(typeVisitor);
				if(!idType.matchesType(exprType)){
					reporter.context().errorInvalidAssignmentType(ctx.expression(), idType, exprType);
				}
			} else{
				reporter.context().errorLHSNotIdentifier(ctx.orExpr());
			}
		}
		return v;
	}
	
	@Override
	public Void visitOpExprBlock(OpExprBlockContext ctx) {
		symbolTable.openScope();
		ctx.statement().forEach((statement) -> statement.accept(this));
		ctx.expression().accept(this);
		symbolTable.closeScope().forEach((entry) ->{
			if(!entry.isUsed()){
				reporter.context().warnUnusedVariable(entry);
			}
		});
		return null;
	}
	

	@Override
	public Void visitNumber(NumberContext ctx) {
		ctx.value = Integer.parseInt(ctx.getText());
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
		if(ctx.op != null){ //and operation exists
			Type left = ctx.primaryExpr().accept(typeVisitor);
			Type right = ctx.multDivModExpr().accept(typeVisitor);
			if(!left.matchesType(Type.INT)) reporter.context().errorBinaryOpType(ctx.primaryExpr(), ctx.op.getText(), Type.INT, right);
			if(!right.matchesType(Type.INT)) reporter.context().errorBinaryOpType(ctx.multDivModExpr(), ctx.op.getText(), Type.INT, right);
		}
		return null;
	}
	
	@Override
	public Void visitPlusMinusExpr(PlusMinusExprContext ctx) {
		super.visitPlusMinusExpr(ctx);
		if(ctx.op != null){ //and operation exists
			Type left = ctx.multDivModExpr().accept(typeVisitor);
			Type right = ctx.plusMinusExpr().accept(typeVisitor);
			if(!left.matchesType(Type.INT)) reporter.context().errorBinaryOpType(ctx.multDivModExpr(), ctx.op.getText(), Type.INT, right);
			if(!right.matchesType(Type.INT)) reporter.context().errorBinaryOpType(ctx.plusMinusExpr(), ctx.op.getText(), Type.INT, right);
		}
		return null;
	}
	
	@Override
	public Void visitCompareExpr(CompareExprContext ctx) {
		super.visitCompareExpr(ctx);
		if(ctx.op != null){ //and operation exists
			Type left = ctx.plusMinusExpr().accept(typeVisitor);
			Type right = ctx.compareExpr().accept(typeVisitor);
			if(!left.matchesType(right)) reporter.context().errorBinaryOpType(ctx.compareExpr(), ctx.op.getText(), left, right);
		}
		return null;
	}
	
	@Override
	public Void visitAndExpr(AndExprContext ctx) {
		super.visitAndExpr(ctx);
		if(ctx.op != null){ //and operation exists
			Type left = ctx.compareExpr().accept(typeVisitor);
			Type right = ctx.andExpr().accept(typeVisitor);
			if(!left.matchesType(Type.BOOLEAN)) reporter.context().errorBinaryOpType(ctx.compareExpr(), ctx.op.getText(), Type.BOOLEAN, right);
			if(!right.matchesType(Type.BOOLEAN)) reporter.context().errorBinaryOpType(ctx.andExpr(), ctx.op.getText(), Type.BOOLEAN, right);
		}
		return null;
	}
	
	@Override
	public Void visitOrExpr(OrExprContext ctx) {
		super.visitOrExpr(ctx);
		if(ctx.op != null){ //and operation exists
			Type left = ctx.andExpr().accept(typeVisitor);
			Type right = ctx.orExpr().accept(typeVisitor);
			if(!left.matchesType(Type.BOOLEAN)) reporter.context().errorBinaryOpType(ctx.andExpr(), ctx.op.getText(), Type.BOOLEAN, right);
			if(!right.matchesType(Type.BOOLEAN)) reporter.context().errorBinaryOpType(ctx.orExpr(), ctx.op.getText(), Type.BOOLEAN, right);
		}
		return null;
	}
	
	
	@Override
	public Void visitOpIdOrFunc(OpIdOrFuncContext ctx) {
		if(ctx.LPAREN() != null){
			
			//TODO typecheck function signature
			//System.out.println(ctx.expression().stream().map((x) -> x.getText()).collect(Collectors.toList()));
			ctx.expression().forEach((expr) -> expr.accept(this));
			return null;
		} else{
			return ctx.id().accept(this);
		}
	}
}