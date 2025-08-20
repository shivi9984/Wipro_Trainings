package Day3_JavaOOPS;

class Vehicle{
	void start() {
		System.out.println("Vehicle Is Starting....");
	}
	
	void stop() {
		System.out.println("Vehicle Is Stopping....");
	}
}

class Car extends Vehicle{
	void honk() {
		System.out.println("Car Is Honking...");
	}
	
	void drive() {
		System.out.println("Car Is Driving...");
	}
}

public class Inheritance {

	public static void main(String[] args) {
		Car c1 = new Car();
		c1.start();
		c1.drive();
		c1.honk();
		c1.stop();

	}

}