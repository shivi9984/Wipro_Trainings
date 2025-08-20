package Day_12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.Scanner;

public class FileReader_Practice {
	
	public static void main(String[] args) throws IOException {
		
		try {
			FileReader reader = new FileReader("Hello.txt");
			
//			Scanner myReader = new Scanner(reader);
//			
//			while(myReader.hasNext()) {
//				System.out.print(myReader.next());
//			}
			
//			myReader.close();
			
			
			int ch;
			while((ch = reader.read())!=-1) {
				System.out.print((char) ch);
			}
			
			reader.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
