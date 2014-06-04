package yapl.context;

import yapl.syntax.YAPLBaseVisitor;
import yapl.syntax.YAPLParser.MultDivModExprContext;
import yapl.syntax.YAPLParser.NumberContext;
import yapl.syntax.YAPLParser.PrimaryExprContext;

public class YAPLPrinter extends YAPLBaseVisitor<Object>{
	@Override
	public Object visitNumber(NumberContext ctx) {
		System.out.println("value: " + ctx.value);
		
		return super.visitNumber(ctx);
	}
	
	@Override
	public Object visitMultDivModExpr(MultDivModExprContext ctx) {
		Object expr = ctx.primaryExpr().accept(this);
		if(ctx.op != null){
			System.out.println(ctx.op.getText());
			ctx.multDivModExpr().accept(this);
		}
		return null;
	}
	
	@Override
	public Object visitPrimaryExpr(PrimaryExprContext ctx) {
		System.out.println(ctx.getText());
		
		return null;
	}
}
