package Day8_Multithreading;

class Bank_System {
    private double balance;

    public Bank_System(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit Amount
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.printf("%s deposited: %.2f, Available Balance: %.2f%n",
                Thread.currentThread().getName(), amount, balance);
    }

    // Withdraw Amount
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.printf("%s withdrew: %.2f, Available Balance: %.2f%n",
                    Thread.currentThread().getName(), amount, balance);
        } else {
            System.out.printf("%s: Insufficient funds for withdrawing %.2f, Available Balance: %.2f%n",
                    Thread.currentThread().getName(), amount, balance);
        }
    }

    // Available Balance
    public double getBalance() {
        return balance;
    }
}

// Thread class to perform transactions
class Transaction extends Thread {
    private Bank_System bank;
    private boolean isDeposit;
    private double amount;

    public Transaction(Bank_System bank, boolean isDeposit, double amount, String name) {
        super(name);
        this.bank = bank;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    public void run() {
        if (isDeposit) {
            bank.deposit(amount);
        } else {
            bank.withdraw(amount);
        }
    }
}


public class Bank_Multithreading {
    public static void main(String[] args) {
    	
        Bank_System bank = new Bank_System(10000);        // Initial balance ₹10,000

        Transaction t1 = new Transaction(bank, false, 7000, "Amit");
        Transaction t2 = new Transaction(bank, false, 5000, "Neha");
        Transaction t3 = new Transaction(bank, true, 3000, "Ravi");

       
        t1.start();
        t2.start();
        t3.start();
    }
}


