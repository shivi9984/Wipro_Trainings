package Day3_JavaOOPS;

class VehicleDemo{
	void run() {
		System.out.println("Vehicle Is Running.");
	}
}

class Bike extends VehicleDemo{
	@Override
	void run() {
		System.out.println("Bike Is Running In Two Wheels.");
	}
}

class Maruti extends VehicleDemo{
	@Override
	void run() {
		System.out.println("Car Is Running In Four Wheels.");
	}
}

public class OverridingExample {

	public static void main(String[] args) {
		VehicleDemo myVehicle1 = new Bike();
		VehicleDemo myVehicle2 = new Maruti();
		
		myVehicle1.run();
		myVehicle2.run();

	}

}
