package Day9_Wrapper_Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Comparable1 {
	
	public static void main(String[] args) {
		Comparator<Integer> c1 = new Comparator<>() {
			public int compare(Integer i, Integer j) {
				if(i > j) 
					return 1;
				else 
					return -1;
				
			}
		};
				
		List l1 = new ArrayList();
		l1.add(10);
		l1.add(40);
		l1.add(50);
		l1.add(20);
		l1.add(35);
		
		Collections.sort(l1, c1);
		System.out.println(l1);
		
	}
}
