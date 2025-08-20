package Day5_Java;

public class Company_Systems {
	public static void main(String[] args) {
		Device_Type d1 = new Laptop("Intel");
		d1.deviceType();
		d1.memorySpace();
		
		Device_Type d2 = new Tablet("ARM");
		d2.deviceType();
		d2.memorySpace();
	}
}
