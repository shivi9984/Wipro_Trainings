package Day6_Java;

interface Bank {
	
    public static final int MIN_BALANCE = 1000;   // we don't need to write public static final in this 
                                                  // because Variables in Interface are public static final by default.
}

class HDFCBank implements Bank {
    public void show() {
    	
        // MIN_BALANCE = 2000;  // ❌ ERROR! Cannot modify final variable
    	
        System.out.println("Min balance: " + MIN_BALANCE);
    }
}

public class Final_Variable {
    public static void main(String[] args) {
        HDFCBank bank = new HDFCBank();
        bank.show();
    }
}
