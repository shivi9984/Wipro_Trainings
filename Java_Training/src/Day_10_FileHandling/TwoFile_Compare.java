package Day_10_FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TwoFile_Compare {
	
	public static void main(String[] args) {
		
		try {
			BufferedReader f1 = new BufferedReader(new FileReader("myfile.txt"));
			BufferedReader f2 = new BufferedReader(new FileReader("Hello.txt"));
			
			String l1;
			String l2;
			
			boolean areSame = true;
			
			while((l1 = f1.readLine()) != null | (l2 = f2.readLine()) != null) {
				
				if(l1 == null || l2 == null || !l1.equals(l2)) {
					areSame = false;
					System.out.println("Files Doesn't have same content.");
					
					break;
				}
			}
			
			f1.close();
			f2.close();
			
			if(areSame) {
				System.out.println("Both files have same content.");
			}
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
