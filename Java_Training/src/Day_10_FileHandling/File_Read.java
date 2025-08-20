package Day_10_FileHandling;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class File_Read {
	
	public static void main(String[] args) {
		try {
			File myfile = new File("myfile.txt");
			Scanner myReader = new Scanner(myfile);
			
			while(myReader.hasNext()) {
				System.out.println(myReader.nextLine());
			}
			
			myReader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Error Occured!!!");
			e.printStackTrace();
		}
	}
}
