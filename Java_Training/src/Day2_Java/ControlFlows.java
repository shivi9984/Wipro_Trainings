package Day2_Java;

import java.util.Scanner;

public class ControlFlows {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter age: ");
		int age = sc.nextInt();
		if(age >= 18) {
			System.out.println("You are adult");
		} else {
			System.out.println("Not Adult");
		}
		
		// Switch 
		
		System.out.print("Enter Channel No. : ");
		int number = sc.nextInt();
		switch(number) {
			case 1 : System.out.println("Aaj Tak");
				break;
			
			case 2 : System.out.println("Zee News");
				break;
			
			default : System.out.println("Channel Not Listed");
			
		}
		
		sc.close();

	}

}
