package Day5_Java;

interface Calculator{
	
	double cal(double a, double b);
}

public class LamdaExample {
	public static void main(String[] args) {
		// Syntax for Lambda Expression in java is: (parameters) -> Body {operation}
		
		Calculator addition = (a, b) -> {
			double result = a+b;
			System.out.println("Addition Result: " +result);
			return result;
			
		};
		
		Calculator subtraction = (a,b) -> {
			double result = a-b;
			System.out.println("Subtraction Result: " +result);
			return result;
		};
	
		
		double a = 50.0;
		double b = 20.0;
		addition.cal(a,b);
		subtraction.cal(a, b);
	}
}
