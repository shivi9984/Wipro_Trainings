package Day6_Java;


interface Vehicle_2 {
    // Abstract method (By default public and abstract)
    void start();

    // Default method 
    default void fuelStatus() {
        System.out.println("Fuel status: Sufficient fuel available.");
    }

    // Static method (belongs to interface)
    
    static void serviceReminder() {
        System.out.println("Service due every 6 months or 5000 km.");
    }
}

class NewCar implements Vehicle_2 {
    
    public void start() {
        System.out.println("Car is starting with the key...");
    }

    
    @Override
    public void fuelStatus() {
        System.out.println("Car fuel status: Full tank.");
    }
}

public class Default_Static_Interface {
    public static void main(String[] args) {
        NewCar myCar = new NewCar();

        // Calling abstract method implementation
        myCar.start();

        // Calling default method
        myCar.fuelStatus();

        // 3. Calling static method (via interface name)
        Vehicle_2.serviceReminder();
    }
}

