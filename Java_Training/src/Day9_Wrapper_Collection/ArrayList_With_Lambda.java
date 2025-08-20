package Day9_Wrapper_Collection;

import java.util.ArrayList;

public class ArrayList_With_Lambda {
	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(20);
		numbers.add(30);
		numbers.add(10);
		numbers.add(50);
		numbers.add(36);
		
		numbers.forEach((n) -> {System.out.println(n);});
	}
}
