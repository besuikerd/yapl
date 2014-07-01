package yapl.reporter;

import java.util.Arrays;

public enum ErrorType {
	/**
	 * an error that occurred during syntactic analysis
	 */
	SYNTAX,
	
	/**
	 * an error that occurred during contextual analysis
	 */
	CONTEXT,
	
	/**
	 * an error that occurred during a semantic walk through the parse tree
	 */
	CODEGEN
	;

	
	/**
	 * The maximum string length of ErrorType names, for String formatting purposes
	 */
	public static final int LONGEST_NAME = Arrays.stream(values()).max((ErrorType a, ErrorType b) ->a.toString().length() > b.toString().length() ? 1 : -1).get().toString().length();
}
