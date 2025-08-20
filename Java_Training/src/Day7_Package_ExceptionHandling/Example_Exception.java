package Day7_Package_ExceptionHandling;

public class Example_Exception {

	public static void main(String[] args) {
		int a = 0; 
		int b = 20;
		int result;
		
		try {
			result = b/a;
			System.out.println("Division gone right. " +result);
		}
		catch(Exception e) {
			System.out.println("Division Gone Wrong. " +e.getMessage());
			throw e;
		}
		finally {
			System.out.println("Operation Completed.");
		}

	}

}
