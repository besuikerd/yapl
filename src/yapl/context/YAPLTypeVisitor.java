package yapl.context;

import yapl.reporter.ErrorReporter;
import yapl.syntax.YAPLBaseVisitor;
import yapl.syntax.YAPLParser.AndExprContext;
import yapl.syntax.YAPLParser.CompareExprContext;
import yapl.syntax.YAPLParser.ExpressionContext;
import yapl.syntax.YAPLParser.IdContext;
import yapl.syntax.YAPLParser.MultDivModExprContext;
import yapl.syntax.YAPLParser.NumberContext;
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
import yapl.syntax.YAPLParser.TypeDenoterContext;
import yapl.typing.PredefFunction;
import yapl.typing.Type;

public class YAPLTypeVisitor extends YAPLBaseVisitor<Type>{
	
	private ErrorReporter reporter;
	
	public YAPLTypeVisitor(ErrorReporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public Type visitExpression(ExpressionContext ctx) {
		return ctx.EQ() == null ? ctx.orExpr().accept(this) : ctx.expression().accept(this);
	}
	
	@Override
	public Type visitOpExprBlock(OpExprBlockContext ctx) {
		return ctx.expression() != null ? ctx.expression().accept(this) : Type.VOID;
	}

	@Override
	public Type visitOpIdOrFunc(OpIdOrFuncContext ctx) {
		Type t = null;
		if(ctx.LPAREN() != null){
			PredefFunction f = PredefFunction.FUNCTIONMAP.get(ctx.id().getText());
			if(f != null){
				switch(f){
				case PRINT:
				case READ:
					return ctx.expression().size() == 1 ? ctx.expression().get(0).accept(this) : Type.VOID;
				}
			} else{
				//TODO implement dynamic functions;
				return Type.VOID;
			}
		} else{
			return ctx.id().accept(this);
		}
		return t;
	}
	
	@Override
	public Type visitOpNumber(OpNumberContext ctx) {
		return Type.INT;
	}
	
	@Override
	public Type visitOpTrue(OpTrueContext ctx) {
		return Type.BOOLEAN;
	}
	
	@Override
	public Type visitOpFalse(OpFalseContext ctx) {
		return Type.BOOLEAN;
	}
	
	@Override
	public Type visitOpParenExpr(OpParenExprContext ctx) {
		return ctx.expression().accept(this);
	}
	
	@Override
	public Type visitOpWhile(OpWhileContext ctx) {
		return Type.VOID;
	}
	
	public Type visitOpIfThenElse(OpIfThenElseContext ctx) {
		Type type = Type.VOID;
		if(ctx.expression().size() == 3){
			Type tIf = ctx.expression().get(1).accept(this);
			Type tElse = ctx.expression().get(2).accept(this);
			if(tIf.matchesType(tElse)){
				type = tIf;
			}
		}
		return type;
	};
	
	@Override
	public Type visitOpChar(OpCharContext ctx) {
		return Type.CHAR;
	}
	
	@Override
	public Type visitPrimaryExpr(PrimaryExprContext ctx) {
		return ctx.operand().accept(this);
	}
	
	@Override
	public Type visitMultDivModExpr(MultDivModExprContext ctx) {
		return ctx.primaryExpr().size() == 1 ? ctx.primaryExpr(0).accept(this) : Type.INT;
	}
	
	@Override
	public Type visitPlusMinusExpr(PlusMinusExprContext ctx) {
		return ctx.multDivModExpr().size() == 1 ? ctx.multDivModExpr(0).accept(this) : Type.INT;
	}
	
	@Override
	public Type visitCompareExpr(CompareExprContext ctx) {
		return ctx.plusMinusExpr().size() == 1 ? ctx.plusMinusExpr(0).accept(this) : Type.BOOLEAN;
	}
	
	@Override
	public Type visitAndExpr(AndExprContext ctx) {
		return ctx.compareExpr().size() == 1 ? ctx.compareExpr(0).accept(this) : Type.BOOLEAN;
	}
	
	@Override
	public Type visitOrExpr(OrExprContext ctx) {
		return ctx.andExpr().size() == 1 ? ctx.andExpr(0).accept(this) : Type.BOOLEAN;
	}
	
	
	@Override
	public Type visitNumber(NumberContext ctx) {
		return Type.INT;
	}
	
	@Override
	public Type visitId(IdContext ctx) {
		return ctx.entry != null && ctx.entry.getType() != null ? ctx.entry.getType() : Type.ERROR;
	}
	
	@Override
	public Type visitTypeDenoter(TypeDenoterContext ctx) {
		Type type = Type.TYPEMAP.get(ctx.getText());
		if(type == null){
			//TODO for dynamic types this needs a different implementation
			reporter.context().error(ctx.start, "Unknown type: %s", ctx.getText());
			type = Type.ERROR;
		}
		return type;
	}
}
