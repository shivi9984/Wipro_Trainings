package Day7_Package_ExceptionHandling;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx_Pattern_Matcher {
	
	public static void main(String[] args) {
		
		// Pattern Program
		Pattern pattern = Pattern.compile("JavaCoding123", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher("Learning JavaCoding Is Fun");
		
		boolean matchFound = matcher.find();
		if(matchFound) {
			System.out.println("Match Found.");
		}
		else {
			System.out.println("Match Not Found.");
		}
	}
}
