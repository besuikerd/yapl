package yapl.context;

import yapl.syntax.YAPLParser.DeclarationContext;

public class IdEntry {
	private String spelling;
	private DeclarationContext ctx;
	private int level;
	private boolean used;

	public IdEntry(String spelling, DeclarationContext ctx, int level){
		this.spelling = spelling;
		this.ctx = ctx;
		this.level = level;
		this.used = false;
	}
	
	public IdEntry(String spelling, DeclarationContext ctx){
		this(spelling, ctx, -1);
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
	
	public boolean isUsed() {
		return used;
	}
	
	public String getSpelling() {
		return spelling;
	}
	
	public void setUsed(boolean used) {
		this.used = used;
	}
}
