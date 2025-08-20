package Day3_JavaOOPS;

class Calculator{
	int add(int a, int b) {
		return a+b;
	}
	
	int add(int a, int b, int c) {
		return a+b+c;
	}
	
	double add(double a, double b) {
		return a+b;
	}
}

public class OverloadingExample {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
			
		System.out.println("Sum of 5 and 9 is= " +cal.add(5, 9));
		System.out.println("Sum of 10, 20 and 30 is= " +cal.add(10,20,30));
		System.out.println("Sum of 3.7 and 5.2 is= " +cal.add(3.7, 5.2));
	}

}