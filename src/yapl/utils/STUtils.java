package yapl.utils;

import org.stringtemplate.v4.ST;

/**
 * Utility class that contain helper functions regarding StringTemplate
 * @author Nicker
 *
 */
public class STUtils {
	
	/**
	 * concatenates multiple StringTemplates together with the given seperator
	 * @param seperator seperator to seperate StringTemplates with
	 * @param concats StringTemplates to concatenate
	 * @return concatenated StringTemplate
	 */
	public static ST concat(String seperator, ST... concats){
		StringBuilder builder = new StringBuilder();
		for(int i = 0 ; i < concats.length ; i++){
			builder.append(concats[i].render());
			if(i < concats.length - 1){
				builder.append(seperator);
			}
		}
		return new ST(builder.toString());
	}
	
	/**
	 * Concats multiple StringTemplates with newlines as a seperator
	 * @param concats StringTemplates to concatenate
	 * @return concatenated StringTemplate
	 */
	public static ST concat(ST... concats){
		return concat("\n", concats);
	}
}
