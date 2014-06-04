package yapl.context;

import java.util.stream.Collectors;

import yapl.reporter.ErrorReporter;
import yapl.syntax.YAPLBaseVisitor;
import yapl.syntax.YAPLParser.DeclConstContext;
import yapl.syntax.YAPLParser.ExprBlockContext;
import yapl.syntax.YAPLParser.NumberContext;
import yapl.syntax.YAPLParser.OpIdOrFuncContext;
import yapl.syntax.YAPLParser.ProgramContext;

public class YAPLChecker extends YAPLBaseVisitor<Object>{
	
	protected SymbolTable<IdEntry> symbolTable;
	protected ErrorReporter reporter;
	
	public YAPLChecker(SymbolTable<IdEntry> symbolTable, ErrorReporter reporter) {
		this.symbolTable = symbolTable;
		this.reporter = reporter;
	}

	@Override
	public Object visitProgram(ProgramContext ctx) {
		symbolTable.openScope();
		ctx.statement().forEach((s) -> s.accept(this));
		symbolTable.closeScope();
		return null;
	}
	
	@Override
	public Object visitExprBlock(ExprBlockContext ctx) {
		symbolTable.openScope();
		ctx.statement().forEach((stat) -> stat.accept(this));
		Object res = ctx.ret().accept(this);
		symbolTable.closeScope();
		return res;
	}
	

	@Override
	public Object visitNumber(NumberContext ctx) {
		ctx.value = Integer.parseInt(ctx.getText());
		reporter.semantic().error("oh noes! a number: " + ctx.value);
		return super.visitNumber(ctx);
	}
	
	@Override
	public Object visitOpIdOrFunc(OpIdOrFuncContext ctx) {
		if(ctx.LPAREN() != null){
			System.out.println(ctx.expression().stream().map((x) -> x.getText()).collect(Collectors.toList()));
		}
		return super.visitOpIdOrFunc(ctx);
	}
}