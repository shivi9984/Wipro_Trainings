package Day6_Java;

interface Car {
    default void start() {
        System.out.println("Car is starting with a key...");
    }
}

interface Bike {
    default void start() {
        System.out.println("Bike is starting with a self-start button...");
    }
}

class Vehicle implements Car, Bike {
    
    @Override                                 // Must override to resolve conflict between Car and Bike start()
    public void start() {
        System.out.println("Vehicle Start Options:\n");
        Car.super.start();                    // calling Car's default method
        Bike.super.start();                   // calling Bike's default method
    }
}

public class Default_Interface {
    public static void main(String[] args) {
        Vehicle hv = new Vehicle();
        hv.start();
    }
}

