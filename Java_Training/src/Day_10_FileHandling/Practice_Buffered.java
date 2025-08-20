package Day_10_FileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice_Buffered {
	
    public static void main(String[] args) {
        try {
        	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        	BufferedWriter writer = new BufferedWriter(new FileWriter("myfile.txt"));
        	
        	System.out.println("Enter Text Here: (Type 'exit' to finish)");
        	
        	String line;
        	while(!(line = reader.readLine()).equalsIgnoreCase("exit")){
        		
        		writer.write(line.toUpperCase());
        		writer.newLine();
        	}
        	
        	reader.close();
        	writer.close();
        	
        	System.out.println("Successful.");
        	
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
    }
}

