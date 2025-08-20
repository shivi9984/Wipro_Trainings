package Day5_Java;

import java.util.Scanner;

class PropertyRent {

    double calculateRent(double monthlyRent, int months) {
        return monthlyRent * months;
    }

    double calculateRent(double monthlyRent, int months, double maintenance, double discount) {
        return (monthlyRent * months) + maintenance - discount;
    }
}

public class Property {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Fixed Prices
        double monthlyRent = 10000;
        double maintenance = 5000;
        double discount = 2000;

        System.out.print("Enter number of months for rent: ");
        int months = sc.nextInt();

        PropertyRent rent = new PropertyRent();
        double totalRent = monthlyRent * months;
        double finalRent = rent.calculateRent(monthlyRent, months, maintenance, discount);

        // Print bill
        System.out.println("\n******** PROPERTY RENT BILL ********");
        System.out.println("Monthly Rent x Months:\t₹" + monthlyRent + " x " + months + " = ₹" + totalRent);
        System.out.println("Maintenance:\t\t₹" + maintenance);
        System.out.println("Discount:\t\t₹" + discount);
        System.out.println("------------------------------------");
        System.out.println("Total Payable Rent:\t₹" + finalRent);
        System.out.println("************************************");

        sc.close();
    }
}


