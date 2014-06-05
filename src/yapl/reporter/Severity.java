package yapl.reporter;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Severity {
	WARNING,
	ERROR;
	
	
	/**
	 * a predicate that checks if the CompilerError's severity is at least the severity level of this Severity ({@link #ordinal()})
	 */
	public Predicate<CompilerError> minLevel(){
		return (x) -> x.getSeverity().ordinal() > ordinal();
	}
	
	/**
	 * a predicate that checks if the CompilerError's severity is at most the severity level of this Severity ({@link #ordinal()})
	 * @return
	 */
	public Predicate<CompilerError> maxLevel(){
		return minLevel().negate();
	}
	
	/**
	 * The maximum string length of Severity names, for String formatting purposes
	 */
	public static final int LONGEST_NAME = Arrays.stream(values()).max((Severity a, Severity b) ->a.toString().length() > b.toString().length() ? 1 : -1).get().toString().length();
}
