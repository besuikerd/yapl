package yapl.reporter;

import java.util.Arrays;

public enum ErrorType {
	SYNTAX,
	CONTEXT,
	SEMANTIC
	;

	
	/**
	 * The maximum string length of ErrorType names, for String formatting purposes
	 */
	public static final int LONGEST_NAME = Arrays.stream(values()).max((ErrorType a, ErrorType b) ->a.toString().length() > b.toString().length() ? 1 : -1).get().toString().length();
}
