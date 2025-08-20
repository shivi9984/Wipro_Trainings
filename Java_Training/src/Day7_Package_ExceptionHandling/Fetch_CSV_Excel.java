package Day7_Package_ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Fetch_CSV_Excel {
    public static void main(String[] args) {
        String file = "C:\\Users\\shiva\\OneDrive\\Desktop\\Eclipse\\Wipro_Training\\src\\Day7_Package_Exception\\Book1.csv"; 
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
            	
                String[] values = line.split(",");     // Split the line by comma

                // Print each value
                for (String val : values) {
                    System.out.print(val + "\t");
                }
                System.out.println();                  // Move to next line
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
        	System.out.println("\nExection Completed...");
        }
    }
}

