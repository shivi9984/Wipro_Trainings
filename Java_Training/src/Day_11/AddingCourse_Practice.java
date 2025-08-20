package Day_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AddingCourse_Practice {
	
	public static void main(String[] args) {
		
		ArrayList<String> courses = new ArrayList<>();
		courses.add("Java");
		courses.add("SQL");
		courses.add("Python");
		courses.add("Java");
		
		for(String c : courses) {
			System.out.println(c);
		}
		
		
		Set<Integer> id = new HashSet<>();
		id.add(101);
		id.add(102);
		id.add(103);
		id.add(104);
		
		for(Integer s1 : id) {
			System.out.println(s1);
		}
		
		Map<String, Integer> list = new HashMap<>();
		list.put("Java", 101);
		list.put("SQL", 102);
		list.put("Python", 103);
		list.put("Java", 104);
		
		for(String l : list.keySet()) {
			System.out.println(l+ " : " +list.get(l));
		}
	}
}
