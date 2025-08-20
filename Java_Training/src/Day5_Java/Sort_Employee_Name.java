package Day5_Java;

import java.util.Arrays;
import java.util.Scanner;

public class Sort_Employee_Name {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of Employees: ");
        int n = Integer.parseInt(sc.nextLine());  

        String[] names = new String[n];

        System.out.println("Enter the names:");
        for (int i = 0; i < n; i++) {
            names[i] = sc.nextLine();
        }

        Arrays.sort(names); 

        System.out.println("\nEmployees Names in alphabetical order:");
        for (String name : names) {
            System.out.println(name);
        }

        sc.close();
    }
}


