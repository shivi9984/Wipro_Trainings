package Day5_Java;

abstract class Vehicle_Function {
	abstract void speed();
	
	abstract void brand();
	
}

class Car extends Vehicle_Function{
	void speed() {
		System.out.println("Car Speed Should Be 60 Km/Hr.");
	}
	void brand() {
		System.out.println("Brand Name Of Car Is : TATA.");
	}
}

class Bike extends Vehicle_Function{
	void speed() {
		System.out.println("Bike Speed Should Be 40 Km/Hr.");
	}
	void brand() {
		System.out.println("Brand Name Of Bike Is : YAMAHA");
	}
}


