package yapl.utils;

import org.stringtemplate.v4.ST;

public class STUtils {
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
	
	public static ST concat(ST... concats){
		return concat("\n", concats);
	}
}
