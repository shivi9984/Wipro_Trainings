package Day9_Wrapper_Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
	int age;
	String name;
	
	public Student(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}
	
}

public class Comparator_String {
	
	public static void main(String[] args) {
		
		Comparator<Student> c = new Comparator<Student>() {
			public int compare(Student i, Student j) {
				if(i.age>j.age)
					return 1;
				else
					return -1;
			}
		};
		
		List<Student> stud = new ArrayList<>();
		stud.add(new Student(23, "Shivam"));
		stud.add(new Student(25, "Alice"));
		stud.add(new Student(26, "Raghav"));
		stud.add(new Student(20, "Ram"));
		
		Collections.sort(stud, c);
		
		for(Student s1 : stud) {
			System.out.println(s1);
		}
	}
}
