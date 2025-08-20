package Day9_Wrapper_Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

class Collections_Comparable implements Comparable<Collections_Comparable> {
		
		private String name ;
		private int age ;
		
		public Collections_Comparable(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		public int compareTo(Collections_Comparable other) {
			return this.age-other.age;
			
		}
		
		public String toString() {
			return name;
		}
		
		public static void main(String[] args) {
		
			List<Collections_Comparable> data = Arrays.asList(new Collections_Comparable("Shivam", 30), new Collections_Comparable("Ayush", 26));
			
			Collections.sort(data);
			System.out.println(data);

	}
		
}
