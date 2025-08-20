package Day9_Wrapper_Collection;

import java.util.HashMap;
import java.util.Map;

public class Collections_Map {

	public static void main(String[] args) {
		
		Map<String, Integer> data = new HashMap<>();
		data.put("A", 30);
		data.put("B", 40);
		data.put("C", 45);
		data.put("D", 25);
		
		System.out.println(data.keySet());
		System.out.println(data.values());
		
		for(String key : data.keySet()) {
			System.out.println(key+ " : " +data.get(key));
		}

	}

}
