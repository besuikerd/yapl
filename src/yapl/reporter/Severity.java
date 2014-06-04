package yapl.reporter;

import java.util.Arrays;

public enum Severity {
	WARNING,
	ERROR;
	
	/**
	 * The maximum string length of Severity names, for String formatting purposes
	 */
	public static final int LONGEST_NAME = Arrays.stream(values()).max((Severity a, Severity b) ->a.toString().length() > b.toString().length() ? 1 : -1).get().toString().length();
}
