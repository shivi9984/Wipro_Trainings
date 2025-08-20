package Day1_Java;

class Car {
    String color;
    String model;

    public Car(String color, String model) {
        this.color = color;
        this.model = model;
    }

    public void displayInfo() {
        System.out.println("Color: " + color + ", Model: " + model);
    }

    public void changeColor(String newColor) {
        this.color = newColor;
    }
}

public class ReferenceVariables {

	public static void main(String[] args) {
		Car myCar = new Car("Red", "Toyota Camry");
		myCar.displayInfo();
		
		Car anotherCar = myCar;
		anotherCar.changeColor("Blue");
		
		myCar.displayInfo(); 
        anotherCar.displayInfo();
		

	}

}
