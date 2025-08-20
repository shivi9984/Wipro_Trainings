package Day5_Java;

public interface Devices {
	void deviceType();
	void memorySpace();
}

abstract class Device_Type implements Devices{
	String processorType;
	
	Device_Type(String processorType){
		this.processorType = processorType;
	}
	
	void deviceReady() {
		System.out.println("Your Device Is Ready. With Having The Processor : " +processorType);
	}
}

class Laptop extends Device_Type{
	Laptop(String processorType){
		super(processorType);
	}
	
	public void deviceType() {
		deviceReady();
		System.out.println("You Have A Laoptop.");
	}
	public void memorySpace() {
		System.out.println("Laptop Have Memory Space Of 32GB.");
	}
}

class Tablet extends Device_Type{
	Tablet(String processorType){
		super(processorType);
	}
	
	public void deviceType() {
		deviceReady();
		System.out.println("You Have A Tablet.");
	}
	public void memorySpace() {
		System.out.println("Tablet Have Memory Space Of 16GB.");
	}
}
