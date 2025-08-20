package Day3_JavaOOPS;

class Student {
	 private String name;
	 private int age;
	
	 // Getter for name
	 public String getName() {
	     return name;
	 }

// Setter for name
public void setName(String newName) {
	     name = newName;
	 }

// Getter for age
public int getAge() {
	     return age;
	 }

// Setter for age
public void setAge(int newAge) {
	     if (newAge > 0) {
	         age = newAge;
	     }
	 }
}

public class EncapsulationExample {
	public static void main(String[] args) {
	     Student s = new Student();
	     s.setName("Shivam");
	     s.setAge(22);
	
	     System.out.println("Name: " + s.getName());
	     System.out.println("Age: " + s.getAge());
	}
}
