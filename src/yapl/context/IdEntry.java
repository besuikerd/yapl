package yapl.context;

import yapl.syntax.YAPLParser.DeclarationContext;
import yapl.typing.Type;

public class IdEntry {
	private String spelling;
	private DeclarationContext ctx;
	
	private int level;
	private boolean used;
	private Type type;

	public IdEntry(String spelling, DeclarationContext ctx, int level, Type type){
		this.spelling = spelling;
		this.ctx = ctx;
		this.level = level;
		this.type = type;
		this.used = false;
		
	}
	
	public IdEntry(String spelling, DeclarationContext ctx, Type type){
		this(spelling, ctx, -1, type);
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
	
	public Type getType() {
		return type;
	}
	
	public void setUsed(boolean used) {
		this.used = used;
	}
}
