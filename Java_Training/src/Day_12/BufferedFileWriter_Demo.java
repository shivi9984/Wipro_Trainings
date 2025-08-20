package Day_12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedFileWriter_Demo {
	
	public static void main(String[] args) {
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Hello.txt", true));
			bw.write("New Text");
			bw.newLine();
			
			bw.close();
			
			System.out.println("Written Successfully");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
