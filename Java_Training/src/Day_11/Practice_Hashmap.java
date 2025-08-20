package Day_11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Practice_Hashmap {
	public static void main(String[] args) {
		Map<String, Integer> resultData = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Select A Option: ");
			System.out.println("1. Add Student");
			System.out.println("2. Get Student Score");
			System.out.println("3. Exit.");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				System.out.print("Enter The Student's Name: ");
				String name = sc.nextLine();
				System.out.print("Enter The Student's Score: ");
				int score = sc.nextInt();
				resultData.put(name, score);
				break;
				
			case 2:
				System.out.print("Enter Student's Name: ");
				String getName = sc.nextLine();
				Integer studentScore = resultData.get(getName);
				if(studentScore != null) {
					System.out.println("Total Score For " +getName+ " is: " +studentScore);
				}
				else {
					System.out.println("Student Not Found!!! Please Enter Correct Name.");
				}
				break;
				
			case 3:
				System.out.println("Thank You.\nExiting....");
				sc.close();
				System.exit(0);
				break;
				
			default:
				System.out.println("Please Choose Correct Option...");
			}
			
		}
	
	}
}
