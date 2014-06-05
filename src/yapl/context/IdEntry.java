package yapl.context;

import yapl.syntax.YAPLParser.DeclarationContext;

public class IdEntry {
	private int level;
	private DeclarationContext ctx;

	public IdEntry(int level, DeclarationContext ctx){
		this.level = level;
		this.ctx = ctx;
	}
	
	public IdEntry(int level) {
		this(level, null);
	}
	
	public IdEntry(DeclarationContext ctx){
		this(-1, ctx);
	}
	
	public IdEntry() {
		this(-1);
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public DeclarationContext getDeclarationContext() {
		return ctx;
	}
}
