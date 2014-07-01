package yapl.tool;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ExecutionException extends Exception{
	private Throwable throwable;

	public ExecutionException(Throwable throwable) {
		this.throwable = throwable;
	}
	
	@Override
	public synchronized Throwable getCause() {
		return throwable.getCause();
	}
	
	@Override
	public String getLocalizedMessage() {
		return throwable.getLocalizedMessage();
	}
	
	@Override
	public String getMessage() {
		return throwable.getMessage();
	}
	
	@Override
	public StackTraceElement[] getStackTrace() {
		return throwable.getStackTrace();
	}
	
	@Override
	public void printStackTrace() {
		throwable.printStackTrace();
	}
	
	@Override
	public void printStackTrace(PrintStream s) {
		throwable.printStackTrace();
	}
	
	@Override
	public void printStackTrace(PrintWriter s) {
		throwable.printStackTrace();
	}
	
	@Override
	public String toString() {
		return String.format("%s[%s]", getClass().getSimpleName(), throwable);
	}
}
