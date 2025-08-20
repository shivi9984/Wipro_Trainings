package Day7_Package_ExceptionHandling;

public class Array_Exception {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		try {
			System.out.println("Print number at 6th position: " +arr[5]);
		}
		catch(Exception e) {            // ArrayIndexOutOfBoundsException
			System.out.println("Not Found!!!\n" +e.getMessage());
		}
	}
}
