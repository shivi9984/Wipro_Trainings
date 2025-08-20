package Day7_Package_ExceptionHandling;

import java.util.regex.Pattern;
import java .util.regex.Matcher;

public class RegEx_Number_String_Pattern {
	
	public static void main(String[] args) {
		
		String[] str = {
				"12345",
				"Shivam",
				"09876",
				"2.34",
				"23rdk",
				"-567",
				"Ram"
		};
		
		// Regular Expression For Numbers To Validate
//		String pattern = "[-+]?\\d*\\.?\\d+";
		
		// For String To Validate.
		String pattern = "^[a-zA-Z_][a-zA-Z0-9_]*$";
		
		Pattern regex = Pattern.compile(pattern);
		
		for(String i : str) {
			Matcher matcher = regex.matcher(i);
			if(matcher.matches()) {
				System.out.println(i+ " Is A Valid Number / String.");
			}
			else {
				System.out.println(i+ " Is A Invalid Number / String.");
			}
		}
	}
}
