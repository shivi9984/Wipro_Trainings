package Day5_Java;

public class Vehicle{
	public static void main(String[] args) {
		Vehicle_Function c1 = new Car();
		c1.speed();
		c1.brand();
		
		Vehicle_Function b1 = new Bike();
		b1.speed();
		b1.brand();
	}
}
