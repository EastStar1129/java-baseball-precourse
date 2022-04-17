package practice;

public class StringUtil {
	
	public static String[] split(String str, String op) {
		return str.split(op);
	}
	
	public static String removeBracket(String str) {
		if(str.length()>1 && str.charAt(0) == '(' && str.charAt(str.length()-1) == ')') {
			return str.substring(1,str.length()-1);
		}
		return str; 
	}
	
	public static char charAt(String str, int i) {
		if(i >= str.length()) {
			throw new StringIndexOutOfBoundsException("Index: "+i+", Size: "+str.length());
		}
		return str.charAt(i);
	}
}
