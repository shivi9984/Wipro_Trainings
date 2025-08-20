package Day_10_FileHandling;

import java.io.IOException;

public class Input {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome To Java Programming.");
		
		int a = System.in.read();
		System.out.println(a);     // Give ASCII value of given input.
	}
}
