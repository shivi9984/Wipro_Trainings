package Day7_Package_ExceptionHandling;

import java.util.Scanner;

public class Factorial_Exception {
    
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } 
        else {
        	
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 

        try {
            System.out.print("Enter a number: ");
            int n = sc.nextInt();

            if (n < 0) {
                throw new Exception("ERROR!!! Entered Number Is Negative.");
            } 
            else {
                System.out.println("Factorial of " + n + " is: " + factorial(n));
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        finally {
        	
            sc.close();  
        }
    }
}

