package Day3_JavaOOPS;

public class BankAccount {
	   private String accountHolder;
	   private double balance;
	   
	   public BankAccount(String accountHolder, double initialBalance) {
	       this.accountHolder = accountHolder;
	       this.balance = initialBalance;
	   }
	   
	   public void deposit(double amount) {
	       balance += amount;
	       System.out.println("Deosited Balance Is: " +amount+ ". New Balance Is: " + balance);
	   }
	   
	   public void withdraw(double amount) {
	       if (amount > balance) {
	           System.out.println("Insufficient balance.");
	       } else {
	           balance -= amount;
	           System.out.println("Withdrawl Balance Is: "+amount + ". Remaining Balance Is: " + balance);
	       }
	   }
	   
	   public void displayDetails() {
	       System.out.println("Account Holder's Name: " + accountHolder);
	       System.out.println("Balance: " + balance);
	   }
	

		public static void main(String[] args) {
		    BankAccount account = new BankAccount("Shivam", 5000);
		    account.deposit(1000);
		    account.withdraw(500);
		    account.displayDetails();
		}
	}
