package Day_12;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_Practice {
	
	public static void main(String[] args) {
		try {
			FileWriter text = new FileWriter("Hello.txt");
			text.write("It's Day 12 of My Wipro Training");
			
			text.close();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("File Writing Successfully Done.");
	}
}
