package Day7_Package_ExceptionHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Fetch_TXT {
	public static void main(String[] args) {
		
		File f1 = new File("C:\\Users\\shiva\\OneDrive\\Desktop\\Eclipse\\Wipro_Training\\src\\Day7_Package_Exception\\Hello.txt");
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(f1));
			String line = bfr.readLine();
			
			while((line = bfr.readLine()) != null) {
				System.out.println(line);	
			}
			bfr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Finally Execution Completed....");
		}
	}
}
