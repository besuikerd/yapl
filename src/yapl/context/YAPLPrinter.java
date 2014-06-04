package yapl.context;

import yapl.syntax.YAPLBaseVisitor;
import yapl.syntax.YAPLParser.NumberContext;

public class YAPLPrinter extends YAPLBaseVisitor<Object>{
	@Override
	public Object visitNumber(NumberContext ctx) {
		System.out.println("value: " + ctx.value);
		
		return super.visitNumber(ctx);
	}
}
