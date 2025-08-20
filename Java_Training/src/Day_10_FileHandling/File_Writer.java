package Day_10_FileHandling;

import java.io.FileWriter;
import java.io.IOException;


public class File_Writer {
	
	public static void main(String[] args) {
		
		// Write In File.
	
		try {
			FileWriter myWriter = new FileWriter("myfile.txt");
			myWriter.write("Hello, my name is Shivam and i'm welcoming you in Java Program.");
			myWriter.close();
			System.out.println("Text Added Successfully.");
		}
		catch(IOException e) {
			System.out.println("Error Occured!!!");
			e.printStackTrace();
		}
		
		
	}
}
