package yapl.utils;

/**
 * 
 * @author Nicker
 * Utility class that contain helper functions regarding chars
 */
public class CharUtils {
	/**
	 * converts a string to a character
	 * @param s
	 * @return
	 */
	public static char string2Char(String s){
		s = s.replaceAll("^'|'$", "");
		char c = '\0';
		if(s.length() == 1){
			c = s.charAt(0);
		} else{
			switch(s.substring(1, s.length() -1)){
			case "\n": c = '\n'; break;
			}
		}
		return c;
	}
}
