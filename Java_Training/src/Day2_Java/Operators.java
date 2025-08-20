package Day2_Java;

public class Operators {

	public static void main(String[] args) {
		int a = 20;
		int b = 30;
		
		// Binary Operators
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(b%a);
		
		// Unary Operators
		System.out.println(a++);
		System.out.println(a--);
		System.out.println(++b);
		System.out.println(--b);
		
		// Relational Operators
		System.out.println(a == b);
		System.out.println(a < b);
		System.out.println(a >= b);
		System.out.println(a != b);
		
		// Logical Operators
		System.out.println(a>10 && b<50);
		System.out.println(a<10 || b<10);
		
		// Assignment Operators
		System.out.println(a += 3);
		System.out.println(b -+ 10);
	}

}
