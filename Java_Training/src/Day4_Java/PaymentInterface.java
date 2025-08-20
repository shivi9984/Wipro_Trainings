package Day4_Java;

interface PaymentInter{
	
	void makePayment();
}

abstract class PaymentSystem implements PaymentInter {
	double amount;
	
	PaymentSystem(double amount){
		this.amount = amount;
	}
	
	void showSuccessMessage() {
		System.out.println("Transcation Successfull..... Upadates Amount Is: " +amount);
	}
}

class RupayCardPayment extends PaymentSystem{
	RupayCardPayment(double amount){
		super(amount);
	}
	
	public void makePayment() {
		System.out.println("Rupay Card Payment Is Done...");
		showSuccessMessage();
	}
}

class NetBanking extends PaymentSystem{
	NetBanking(double amount){
		super(amount);
	}
	
	public void makePayment() {
		System.out.println("Net Banking Payment Is Done...");
		showSuccessMessage();
	}
}

public class PaymentInterface{
	public static void main(String[] args) {
		PaymentSystem p1 = new RupayCardPayment(10000);
		p1.makePayment();
		
		PaymentSystem p2 = new NetBanking(50000);
		p2.makePayment();
	}
}