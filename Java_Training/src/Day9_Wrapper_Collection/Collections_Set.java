package Day9_Wrapper_Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//import java.util.TreeSet;

public class Collections_Set {
	public static void main(String[] args) {
		
		Set<Integer> data = new HashSet<>();     // O/P will be Unordered Set
//		Set<Integer> data = new TreeSet<>();     // O/P will be Sorted Set
		data.add(10);
//		data.add("Hello");
		data.add(40);
		data.add(15);
		data.add(50);
//		data.add("Shivam");
		
//		System.out.println(data);
		
		Iterator<Integer> i = data.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());

		}
		
		for(int a : data) {
			System.out.println(a);
		}
	}
}
