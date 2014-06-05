package yapl.context;

import yapl.syntax.YAPLBaseVisitor;
import yapl.syntax.YAPLParser.AndExprContext;
import yapl.syntax.YAPLParser.CompareExprContext;
import yapl.syntax.YAPLParser.ExprBlockContext;
import yapl.syntax.YAPLParser.IdContext;
import yapl.syntax.YAPLParser.MultDivModExprContext;
import yapl.syntax.YAPLParser.NumberContext;
import yapl.syntax.YAPLParser.OpIdOrFuncContext;
import yapl.syntax.YAPLParser.OrExprContext;
import yapl.syntax.YAPLParser.PlusMinusExprContext;
import yapl.syntax.YAPLParser.PrimaryExprContext;
import yapl.typing.PredefFunction;
import yapl.typing.Type;

public class YAPLTypeVisitor extends YAPLBaseVisitor<Type>{


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
	public Type visitPrimaryExpr(PrimaryExprContext ctx) {
		return ctx.operand().accept(this);
	}
	
	@Override
	public Type visitMultDivModExpr(MultDivModExprContext ctx) {
		return ctx.op == null ? ctx.primaryExpr().accept(this) : Type.INT;
	}
	
	@Override
	public Type visitPlusMinusExpr(PlusMinusExprContext ctx) {
		return ctx.op == null ? ctx.multDivModExpr().accept(this) : Type.INT;
	}
	
	@Override
	public Type visitCompareExpr(CompareExprContext ctx) {
		return ctx.op == null ? ctx.plusMinusExpr().accept(this) : Type.BOOLEAN;
	}
	
	@Override
	public Type visitAndExpr(AndExprContext ctx) {
		return ctx.op == null ? ctx.compareExpr().accept(this) : Type.BOOLEAN;
	}
	
	@Override
	public Type visitOrExpr(OrExprContext ctx) {
		return ctx.op == null ? ctx.andExpr().accept(this) : Type.BOOLEAN;
	}
	
	
	@Override
	public Type visitNumber(NumberContext ctx) {
		return Type.INT;
	}
	
	@Override
	public Type visitId(IdContext ctx) {
		return ctx.ctx != null ? ctx.ctx.type : Type.ERROR;
	}
	
	
}
