package yapl.context;

public class InvalidScopeLevelException extends SymbolTableException{
	
	private static final long serialVersionUID = 5667254077913817266L;
	
	private int level;

	public InvalidScopeLevelException(int level) {
		super(String.format("invalid scope level: %d", level));
		this.level = level;
	}
	
	
	public int getLevel() {
		return level;
	}
}
