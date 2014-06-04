package yapl.reporter;

public class CompilerError {
	protected String message;
	protected Severity severity;
	protected ErrorType type;
	
	public CompilerError(String message, Severity severity, ErrorType type) {
		this.message = message;
		this.severity = severity;
		this.type = type;
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
	
	@Override
	public String toString() {
		return String.format(String.format("%%-%ds| %%s", ErrorType.LONGEST_NAME + Severity.LONGEST_NAME + 2), String.format("%s(%s)", getSeverity(), getType()), getMessage());
	}
}
