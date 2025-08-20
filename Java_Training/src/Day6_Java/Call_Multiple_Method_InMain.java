package Day6_Java;

import java.util.Scanner;

interface CreditCard {
    void processPayment();
}

interface UPI {
    void processPayment();
}

interface Wallet {
    void processPayment();
}

class PaymentGateway implements CreditCard, UPI, Wallet {
    public void processPayment() {
        System.out.println("Processing payment...");
    }

    // Specific implementations
    public void payByCreditCard() {
        System.out.println("Payment done using Credit Card.");
    }

    public void payByUPI() {
        System.out.println("Payment done using UPI.");
    }

    public void payByWallet() {
        System.out.println("Payment done using Wallet.");
    }
}

public class Call_Multiple_Method_InMain {
    public static void main(String[] args) {
        PaymentGateway pg = new PaymentGateway();
        Scanner sc = new Scanner(System.in);

        System.out.println("Select Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.println("3. Wallet");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
            	pg.processPayment();
                pg.payByCreditCard();
                break;
            case 2:
            	pg.processPayment();
                pg.payByUPI();
                break;
            case 3:
            	pg.processPayment();
                pg.payByWallet();
                break;
            default:
                System.out.println("Invalid choice.");
        }

        sc.close();
    }
}

