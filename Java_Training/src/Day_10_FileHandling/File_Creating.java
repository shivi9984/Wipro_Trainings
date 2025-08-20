package Day_10_FileHandling;

import java.io.File;
import java.io.IOException;

public class File_Creating {

	public static void main(String[] args) {
		
		try {
			File file = new File("myfile.txt");
			if(file.createNewFile()) {         // Create File Within Project.
				System.out.println("File Created: " +file.getName());
			}
			else {
				System.out.println("File Already Exists.");
			}
		}
		catch(IOException e) {
			System.out.println("An Error Occurred.");
			e.printStackTrace();
		}

	}

}
