package Day_11;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIterator_Demo{
	
	public static void main(String[] args) {
		
		List<Integer> num = new ArrayList<>(List.of(20,30,10,50,35));
		ListIterator<Integer> li = num.listIterator();
		
		System.out.println("Forward: ");
		while(li.hasNext()) {
			System.out.println(li.next());
		}
		
		System.out.println("Backward: ");
		while(li.hasPrevious()) {
			System.out.println(li.previous());
		}
	}
}

