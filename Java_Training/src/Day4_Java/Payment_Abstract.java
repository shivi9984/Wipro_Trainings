package Day4_Java;

abstract class Payment {
	double amount;
	
	Payment(double amount){
		this.amount = amount;
	}
	
	abstract void makePayment();
	
	void showSuccessMessage() {
		System.out.println("Transaction Successfull...  Updated Balance is: " +amount);
	}
}

class CreditCardPayment extends Payment{
	
	CreditCardPayment(double amount){
		super(amount);
	}
	
	void makePayment() {
		System.out.println("Credit Card Payment Is Done...");
		showSuccessMessage();
	}
}

class UPI extends Payment{
	
	UPI(double amount){
		super(amount);
	}
	
	void makePayment() {
		System.out.println("UPI Payment Is Done...");
		showSuccessMessage();
	}
}

public class Payment_Abstract{
	public static void main(String[] arg) {
		Payment p1 = new CreditCardPayment(20000);
		p1.makePayment();
		
		Payment p2 = new UPI(35000);
		p2.makePayment();
	}
	
}