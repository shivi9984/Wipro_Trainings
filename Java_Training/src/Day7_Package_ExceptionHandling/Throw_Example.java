package Day7_Package_ExceptionHandling;

import java.util.Scanner;

public class Throw_Example {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Enter Age: ");
			int age = sc.nextInt();
			if(age < 0) {
				
				// To throw a custom error message
				throw new IllegalArgumentException("Age cann't be negative");
			}
			else {
				System.out.println("Your age Is: " +age);
			}
			
		}
		catch(IllegalArgumentException e) {
			System.out.println("Exception Occured: " +e.getMessage());
		}
		finally {
			
			sc.close();
		}
	}
}
