package yapl.context;

import yapl.syntax.YAPLBaseVisitor;
import yapl.syntax.YAPLParser.ExprconstructContext;
import yapl.syntax.YAPLParser.MultDivModExprContext;
import yapl.syntax.YAPLParser.NumberContext;

public class YAPLChecker extends YAPLBaseVisitor<Object>{
	@Override
	public Object visitNumber(NumberContext ctx) {
		ctx.value = Integer.parseInt(ctx.getText());
	
		return super.visitNumber(ctx);
	}
	
	@Override
	public Object visitMultDivModExpr(MultDivModExprContext ctx) {
		
		
		
		
		return null;
	}
}