package yapl.context;

import yapl.syntax.YAPLBaseVisitor;
import yapl.syntax.YAPLParser.AndExprContext;
import yapl.syntax.YAPLParser.CompareExprContext;
import yapl.syntax.YAPLParser.ExpressionContext;
import yapl.syntax.YAPLParser.MultDivModExprContext;
import yapl.syntax.YAPLParser.OpCharContext;
import yapl.syntax.YAPLParser.OpCompareContext;
import yapl.syntax.YAPLParser.OpExprBlockContext;
import yapl.syntax.YAPLParser.OpIdOrFuncContext;
import yapl.syntax.YAPLParser.OpIfThenElseContext;
import yapl.syntax.YAPLParser.OpNumberContext;
import yapl.syntax.YAPLParser.OpParenExprContext;
import yapl.syntax.YAPLParser.OpTrueContext;
import yapl.syntax.YAPLParser.OpWhileContext;
import yapl.syntax.YAPLParser.OrExprContext;
import yapl.syntax.YAPLParser.PlusMinusExprContext;
import yapl.syntax.YAPLParser.PrimaryExprContext;

/**
 * Visitor class that determines wheter an expression is an Identifier (variable
 * or constant) or not
 * @author Nicker
 *
 */
public class IsIdentifierVisitor extends YAPLBaseVisitor<Boolean>{
	@Override
	public Boolean visitExpression(ExpressionContext ctx) {
		return ctx.orExpr().accept(this);
	}
	
	@Override
	public Boolean visitOrExpr(OrExprContext ctx) {
		return ctx.andExpr().size() == 1 && ctx.andExpr(0).accept(this);
	}
	
	@Override
	public Boolean visitAndExpr(AndExprContext ctx) {
		return ctx.compareExpr().size() == 1  && ctx.compareExpr(0).accept(this);
	}
	
	@Override
	public Boolean visitCompareExpr(CompareExprContext ctx) {
		return ctx.plusMinusExpr().size() == 1 && ctx.plusMinusExpr(0).accept(this);
	}
	
	@Override
	public Boolean visitPlusMinusExpr(PlusMinusExprContext ctx) {
		return ctx.multDivModExpr().size() == 1 && ctx.multDivModExpr(0).accept(this);
	}
	
	@Override
	public Boolean visitMultDivModExpr(MultDivModExprContext ctx) {
		return ctx.primaryExpr().size() == 1 && ctx.primaryExpr(0).accept(this);
	}
	
	@Override
	public Boolean visitPrimaryExpr(PrimaryExprContext ctx) {
		return ctx.operand().accept(this);
	}
	
	@Override
	public Boolean visitOpChar(OpCharContext ctx) {
		return false;
	}
	
	public Boolean visitOpFalse(yapl.syntax.YAPLParser.OpFalseContext ctx) {
		return false;
	};
	
	@Override
	public Boolean visitOpTrue(OpTrueContext ctx) {
		return false;
	}
	
	@Override
	public Boolean visitOpExprBlock(OpExprBlockContext ctx) {
		return false;
	}
	
	@Override
	public Boolean visitOpIfThenElse(OpIfThenElseContext ctx) {
		return false;
	}
	
	@Override
	public Boolean visitOpWhile(OpWhileContext ctx) {
		return false;
	}
	
	@Override
	public Boolean visitOpNumber(OpNumberContext ctx) {
		return false;
	}
	
	@Override
	public Boolean visitOpParenExpr(OpParenExprContext ctx) {
		return false;
	}
	
	@Override
	public Boolean visitOpIdOrFunc(OpIdOrFuncContext ctx) {
		return ctx.LPAREN() == null;
	}
}
