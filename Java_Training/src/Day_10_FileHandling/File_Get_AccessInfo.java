package Day_10_FileHandling;

import java.io.File;

public class File_Get_AccessInfo {
	
	public static void main(String[] args) {
		
		File myfile = new File("myfile.txt");
		
		if(myfile.exists()) {
			System.out.println("Name of file: " +myfile.getName());
			System.out.println("File Path: " +myfile.getPath());
			System.out.println("File Exact Path: " +myfile.getAbsolutePath());
			System.out.println("Readable: " +myfile.canRead());
			System.out.println("Writable: " +myfile.canWrite());
			System.out.println("File Length: " +myfile.length());

		}
		else {
			System.out.println("File Not Found!!!");
		}
	}
}
