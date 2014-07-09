package yapl.context;

import yapl.context.ConstantExpression.ConstantType;
import yapl.context.IdEntry.EntryType;
import yapl.syntax.YAPLBaseVisitor;
import yapl.syntax.YAPLParser.AndExprContext;
import yapl.syntax.YAPLParser.CompareExprContext;
import yapl.syntax.YAPLParser.ExpressionContext;
import yapl.syntax.YAPLParser.IdContext;
import yapl.syntax.YAPLParser.MultDivModExprContext;
import yapl.syntax.YAPLParser.OpCharContext;
import yapl.syntax.YAPLParser.OpFalseContext;
import yapl.syntax.YAPLParser.OpIdOrFuncContext;
import yapl.syntax.YAPLParser.OpNumberContext;
import yapl.syntax.YAPLParser.OpParenExprContext;
import yapl.syntax.YAPLParser.OpTrueContext;
import yapl.syntax.YAPLParser.OrExprContext;
import yapl.syntax.YAPLParser.PlusMinusExprContext;
import yapl.syntax.YAPLParser.PrimaryExprContext;
import yapl.utils.CharUtils;

/**
 * Visitor class that can visit Expressions to verify if the expression can be
 * calculated at compile so it does not need to store a constant variable in
 * memory but it can directly emit the constant as a literal.
 * @author Nicker
 *
 */
public class ConstantExpressionVisitor extends YAPLBaseVisitor<ConstantExpression>{
	@Override
	public ConstantExpression visitExpression(ExpressionContext ctx) {
		return ctx.orExpr().accept(this);
	}
	
	@Override
	public ConstantExpression visitOpParenExpr(OpParenExprContext ctx) {
		return ctx.expression().accept(this);
	}
	
	@Override
	public ConstantExpression visitOpNumber(OpNumberContext ctx) {
		return new ConstantExpression(Integer.parseInt(ctx.number().getText()), ConstantType.KNOWN_VALUE);
	}

	@Override
	public ConstantExpression visitOpFalse(OpFalseContext ctx) {
		return new ConstantExpression(0, ConstantType.KNOWN_VALUE);
	}
	
	@Override
	public ConstantExpression visitOpTrue(OpTrueContext ctx) {
		return new ConstantExpression(1, ConstantType.KNOWN_VALUE);
	}
	
	@Override
	public ConstantExpression visitOpChar(OpCharContext ctx) {
		return new ConstantExpression(CharUtils.string2Char(ctx.CHARLITERAL().getText()), ConstantType.KNOWN_VALUE);
	}
	
	
	@Override
	public ConstantExpression visitPrimaryExpr(PrimaryExprContext ctx) {
		ConstantExpression expr = ctx.operand().accept(this);
		if(ctx.op != null){
			switch(ctx.op.getText()){
			case "-": expr = expr.newValue(-expr.getValue()); break;
			case "!": expr = expr.newValue(expr.getValue() ^ 1); break;
			}
		}
		return expr;
	}
	
	@Override
	public ConstantExpression visitMultDivModExpr(MultDivModExprContext ctx) {
		ConstantExpression expr = ctx.primaryExpr(0).accept(this);
		for(int i = 1 ; i < ctx.primaryExpr().size() && expr.getConstantType() == ConstantType.KNOWN_VALUE; i++){
			ConstantExpression nextExpr = ctx.primaryExpr(i).accept(this);
			if(nextExpr.getConstantType() == ConstantType.KNOWN_VALUE){
				switch(ctx.opMultDivMod(i - 1).getText()){
				case "*": expr = expr.newValue(expr.getValue() * nextExpr.getValue()); break;
				case "/": expr = expr.newValue(expr.getValue() / nextExpr.getValue()); break;
				case "%": expr = expr.newValue(expr.getValue() % nextExpr.getValue()); break;
				}
			} else{
				expr = nextExpr;
			}
		}
		return expr;
	}
	
	@Override
	public ConstantExpression visitPlusMinusExpr(PlusMinusExprContext ctx) {
		ConstantExpression expr = ctx.multDivModExpr(0).accept(this);
		for(int i = 1 ; i < ctx.multDivModExpr().size() && expr.getConstantType() == ConstantType.KNOWN_VALUE ; i++){
			ConstantExpression nextExpr = ctx.multDivModExpr(i).accept(this);
			if(nextExpr.getConstantType() == ConstantType.KNOWN_VALUE){
				switch(ctx.opPlusMinus(i - 1).getText()){
				case "+": expr = expr.newValue(expr.getValue() + nextExpr.getValue()); break;
				case "-": expr = expr.newValue(expr.getValue() - nextExpr.getValue()); break;
				}
			} else{
				expr = nextExpr;
			}
		}
		return expr;
	}
	
	@Override
	public ConstantExpression visitCompareExpr(CompareExprContext ctx) {
		ConstantExpression expr = ctx.plusMinusExpr(0).accept(this);
		for(int i = 1 ; i < ctx.plusMinusExpr().size() && expr.getConstantType() == ConstantType.KNOWN_VALUE ; i++){
			ConstantExpression nextExpr = ctx.plusMinusExpr(i).accept(this);
			if(nextExpr.getConstantType() == ConstantType.KNOWN_VALUE){
				switch(ctx.opCompare(i - 1).getText()){
				case ">": expr = expr.newValue(expr.getValue() > nextExpr.getValue() ? 1 : 0); break;
				case ">=": expr = expr.newValue(expr.getValue() >= nextExpr.getValue() ? 1 : 0); break;
				case "<": expr = expr.newValue(expr.getValue() < nextExpr.getValue() ? 1 : 0); break;
				case "<=": expr = expr.newValue(expr.getValue() <= nextExpr.getValue() ? 1 : 0); break;
				case "==": expr = expr.newValue(expr.getValue() == nextExpr.getValue() ? 1 : 0); break;
				case "!=": expr = expr.newValue(expr.getValue() != nextExpr.getValue() ? 1 : 0); break;
				}
			} else{
				expr = nextExpr;
			}
		}
		return expr;
	}
	
	@Override
	public ConstantExpression visitAndExpr(AndExprContext ctx) {
		ConstantExpression expr = ctx.compareExpr(0).accept(this);
		for(int i = 1 ; i < ctx.compareExpr().size() && expr.getConstantType() == ConstantType.KNOWN_VALUE ; i++){
			ConstantExpression nextExpr = ctx.compareExpr(i).accept(this);
			expr = nextExpr.getConstantType() == ConstantType.KNOWN_VALUE ? expr.newValue(expr.getValue() == 1 && nextExpr.getValue() == 1 ? 1 : 0) : nextExpr;
		}
		return expr;
	}
	
	@Override
	public ConstantExpression visitOrExpr(OrExprContext ctx) {
		ConstantExpression expr = ctx.andExpr(0).accept(this);
		for(int i = 1; i < ctx.andExpr().size() && expr.getConstantType() == ConstantType.KNOWN_VALUE ; i++){
			ConstantExpression nextExpr = ctx.andExpr(i).accept(this);
			expr = nextExpr.getConstantType() == ConstantType.KNOWN_VALUE ? expr.newValue(expr.getValue() == 1 || nextExpr.getValue() == 1 ? 1 : 0) : nextExpr;
		}
		return expr;
	}
	
	@Override
	public ConstantExpression visitOpIdOrFunc(OpIdOrFuncContext ctx) {
		ConstantExpression cons = null;
		if(ctx.LPAREN() != null){
			//TODO nested constants
			cons = new ConstantExpression(-1, ConstantType.UNKNOWN_VALUE);
		} else{
			//TODO functions
			IdContext idCtx = ctx.id();
			System.out.println(idCtx.entry);
			cons = idCtx.entry.getEntryType() == EntryType.CONSTANT ? idCtx.entry.getConstantExpression() : new ConstantExpression(-1, ConstantType.UNKNOWN_VALUE);
		}
		return cons;
	}
}
