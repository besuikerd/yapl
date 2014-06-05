package yapl.reporter;

public class CompilerError {
	protected String message;
	protected Severity severity;
	protected ErrorType type;
	private int line;
	private int charPos;
	
	
	public CompilerError(String message, Severity severity, ErrorType type, int line, int charPos) {
		this.message = message;
		this.severity = severity;
		this.type = type;
		this.line = line;
		this.charPos = charPos;
	}

	public String getMessage() {
		return message;
	}
	
	public Severity getSeverity() {
		return severity;
	}
	
	public ErrorType getType() {
		return type;
	}
	
	public int getLine() {
		return line;
	}
	
	public int getCharPos() {
		return charPos;
	}
	
	@Override
	public String toString() {
		return String.format(String.format("%%-%ds[%%d:%%d]| %%s", ErrorType.LONGEST_NAME + Severity.LONGEST_NAME + 2), String.format("%s(%s)", getSeverity(), getType()), getLine(), getCharPos(), getMessage());
	}
}
