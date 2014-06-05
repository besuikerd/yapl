package yapl.context;

import java.util.stream.Collectors;

import yapl.reporter.ErrorReporter;
import yapl.syntax.YAPLBaseVisitor;
import yapl.syntax.YAPLParser.AndExprContext;
import yapl.syntax.YAPLParser.DeclConstContext;
import yapl.syntax.YAPLParser.DeclVarContext;
import yapl.syntax.YAPLParser.ExprBlockContext;
import yapl.syntax.YAPLParser.IdContext;
import yapl.syntax.YAPLParser.NumberContext;
import yapl.syntax.YAPLParser.OpIdOrFuncContext;
import yapl.syntax.YAPLParser.YaplContext;
import yapl.typing.Type;

public class YAPLChecker extends YAPLBaseVisitor<Void>{
	
	protected SymbolTable<IdEntry> symbolTable;
	protected ErrorReporter reporter;
	protected YAPLTypeVisitor typeVisitor;
	
	public YAPLChecker(SymbolTable<IdEntry> symbolTable, ErrorReporter reporter) {
		this.symbolTable = symbolTable;
		this.reporter = reporter;
		this.typeVisitor = new YAPLTypeVisitor();
	}

	@Override
	public Void visitYapl(YaplContext ctx) {
		symbolTable.openScope();
		ctx.statement().forEach((s) -> s.accept(this));
		symbolTable.closeScope();
		return null;
	}
	
	@Override
	public Void visitExprBlock(ExprBlockContext ctx) {
		symbolTable.openScope();
		ctx.statement().forEach((stat) -> stat.accept(this));
		Object res = ctx.expression().accept(this);
		symbolTable.closeScope();
		return null;
	}
	
	@Override
	public Void visitDeclVar(DeclVarContext ctx) {
		IdEntry entry = new IdEntry(ctx);
		ctx.type = ctx.typeDenoter().accept(typeVisitor);
		
		try {
			symbolTable.enter(ctx.id().getText(), entry);
		} catch(SymbolTableException e){
			reporter.context().error(ctx.id().start, e.getMessage());
		}
		
		return super.visitDeclVar(ctx);
	}
	
	@Override
	public Void visitDeclConst(DeclConstContext ctx) {
		IdEntry entry = new IdEntry(ctx);
		ctx.type = ctx.expression().accept(typeVisitor);
		try{
			symbolTable.enter(ctx.id().getText(), entry);
		} catch(SymbolTableException e){
			reporter.context().error(ctx.id().start, e.getMessage());
		}
		
		return super.visitDeclConst(ctx);
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
			ctx.ctx = entry.getDeclarationContext();
		}
		return super.visitId(ctx);
	}
	
	@Override
	public Void visitAndExpr(AndExprContext ctx) {
		if(ctx.op != null){ //and operation exists
			Type left = ctx.compareExpr().accept(typeVisitor);
			Type right = ctx.andExpr().accept(typeVisitor);
			if(!left.matchesType(Type.BOOLEAN)){
				reporter.context().error(ctx.compareExpr().start, "expected type: %s, got: %s", Type.BOOLEAN, left);
			}
			
			if(!right.matchesType(Type.BOOLEAN)){
				reporter.context().error(ctx.andExpr().start, "expected type: %s, got: %s", Type.BOOLEAN, right);
			}
		}
		
		return super.visitAndExpr(ctx);
	}
	
	@Override
	public Void visitOpIdOrFunc(OpIdOrFuncContext ctx) {
		if(ctx.LPAREN() != null){
			System.out.println(ctx.expression().stream().map((x) -> x.getText()).collect(Collectors.toList()));
		}
		return super.visitOpIdOrFunc(ctx);
	}
}