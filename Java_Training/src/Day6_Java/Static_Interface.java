package Day6_Java;

interface Payment {
    static void showInfo() {
        System.out.println("All payments are processed securely.");
    }

    void processPayment(); 
}

class CreditCardPayment implements Payment {
    public void processPayment() {
        System.out.println("Processing Credit Card Payment...");
    }
}

public class Static_Interface {
    public static void main(String[] args) {
    	
        // Call static method of interface
        Payment.showInfo();

        // Create object of implementing class
        
        Payment p = new CreditCardPayment();
        p.processPayment();

        // p.showInfo();         // This Will Show ERROR! static methods can't be called through object. We need to call it using Interface Name.
    }
}
