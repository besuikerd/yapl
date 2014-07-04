package yapl.context;

import yapl.syntax.YAPLParser.DeclarationContext;
import yapl.typing.Type;

public class IdEntry {
	private String spelling;
	private DeclarationContext ctx;
	private int level;
	private boolean used;
	private Type type;
	private int offset;
	
	private EntryType entryType;
	private ConstantExpression constantExpression;

	public IdEntry(String spelling, DeclarationContext ctx, int level, Type type, EntryType entryType){
		this.spelling = spelling;
		this.ctx = ctx;
		this.level = level;
		this.type = type;
		this.used = false;
		this.entryType = entryType;
	}
	
	public IdEntry(String spelling, DeclarationContext ctx, Type type, EntryType entryType){
		this(spelling, ctx, -1, type, entryType);
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	public int getOffset() {
		return offset;
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
	
	public EntryType getEntryType() {
		return entryType;
	}
	
	public void setUsed(boolean used) {
		this.used = used;
	}
	
	public ConstantExpression getConstantExpression() {
		return constantExpression;
	}
	
	public void setConstantExpression(ConstantExpression constantExpression) {
		this.constantExpression = constantExpression;
	}
	
	public enum EntryType{
		VARIABLE,
		CONSTANT;
	}
}
