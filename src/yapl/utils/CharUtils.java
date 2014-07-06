package yapl.utils;

public class CharUtils {
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
