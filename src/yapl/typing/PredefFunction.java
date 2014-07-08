package yapl.typing;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.misc.Pair;

/**
 * enum that defines all different predefined functions
 * @author Nicker
 *
 */
public enum PredefFunction {
	PRINT("print"),
	READ("read");
	
	/**
	 * maps spelling of PredefFunctions to their Enum instances
	 */
	public static final Map<String, PredefFunction> FUNCTIONMAP = Arrays.stream(values()).map( (x) -> new Pair<String, PredefFunction>(x.spelling, x)).collect(Collectors.toMap((Pair<String, PredefFunction> x) -> x.a, (Pair<String, PredefFunction> x) -> x.b)); 
	
	private String spelling;

	private PredefFunction(String spelling) {
		this.spelling = spelling;
	}
	
	public String getSpelling() {
		return spelling;
	}
	
	@Override
	public String toString() {
		return spelling;
	}
}
