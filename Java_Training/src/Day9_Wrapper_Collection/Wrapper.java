package Day9_Wrapper_Collection;

public class Wrapper {

	public static void main(String[] args) {
		int a = 10;
		Integer i = a;    // primitive to object is called Auto-boxing.
		
		int b = i.intValue();   // object to primitive is called Un-boxing.
//		int b = i;              // Autoun-boxing
		
		System.out.println(b);
	}

}
