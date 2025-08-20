package Day6_Java;

interface Calculator{
	
	void add(final int a, int b );
}

class Demo implements Calculator{
	public void add(final int a, int b) {
		
		// a = a+b;           // Will throw an error, if we try to reassign the value of final variable a.
		
		System.out.println(a+b);
	}
}

public class Final_In_Arguments {
	public static void main(String[] args) {
		Demo c1 = new Demo();
		c1.add(5, 6);
	}

}
