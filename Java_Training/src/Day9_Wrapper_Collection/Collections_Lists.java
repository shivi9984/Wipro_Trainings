package Day9_Wrapper_Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Collections_Lists {

	public static void main(String[] args) {
		
		List<Integer> num = new ArrayList<>();
		num.add(10);
		num.add(20);
		num.add(30);
		num.add(40);
		num.add(50);
		
		System.out.println(num.get(2)); 
		System.out.println(num.indexOf(50)); 

		
//		for(int i=0; i<num.size(); i++) {
//			System.out.println(num.get(i));
//		}
		
		for(Object i : num) {
			
			int num1 = (Integer) i;
			System.out.println(num1);
		}
		

	}

}
