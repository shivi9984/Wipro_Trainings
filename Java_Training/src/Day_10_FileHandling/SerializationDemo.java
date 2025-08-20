package Day_10_FileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String name;
	int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Student() {
		super();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student{Name='" + name + "', Age=" + age + "}";
	}

}

public class SerializationDemo {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Student s1 = new Student();
		s1.setName("Shivam");
		s1.setAge(25);
		
		
		FileOutputStream out = new FileOutputStream("C:\\Users\\shiva\\OneDrive\\Desktop\\Eclipse\\Wipro_Training\\src\\Day_10_FileHandling\\Hi.txt");
		ObjectOutputStream output = new ObjectOutputStream(out);
		output.writeObject(s1);
		
		out.close();
		output.close();
		
		FileInputStream in = new FileInputStream("C:\\Users\\shiva\\OneDrive\\Desktop\\Eclipse\\Wipro_Training\\src\\Day_10_FileHandling\\Hi.txt");
		ObjectInputStream input = new ObjectInputStream(in);
		Student s2 =(Student) input.readObject();
		
//		s2.setName("Raj");
//		s2.setAge(22);
		
		System.out.println("Deserialized Student: " + s2);

		input.close();
		in.close();
		
		
	}
}
