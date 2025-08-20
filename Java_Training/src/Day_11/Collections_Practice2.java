package Day_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Collections_Practice2 {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(60,40,20,35,10,50));
		a.add(55);
		System.out.println(a);
		
		Collections.sort(a);
		System.out.println("Sorted: " +a);
		
		int b = Collections.binarySearch(a, 55);
		System.out.println("Index of 55 in sorted list: " +b);
		
		Collections.reverse(a);
		System.out.println(a);
		
	
	}
}
