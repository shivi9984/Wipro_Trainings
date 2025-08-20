package Day_11;

import java.util.ArrayList;
import java.util.Collections;

public class Collection_Practice {
	
	class department{
		private String name;
		private double sales;
		private double expenses;
		
		public department(String name, double sales, double expenses) {
			this.name = name;
			this.sales = sales;
			this.expenses = expenses;
		}
		
		public double getProfit() {
			return sales - expenses;
		}
		
		public String getName() {
			return name;
		}
		
	}
	
		public static void main(String[] args) {
			ArrayList<department> depart = new ArrayList<>();
			
			Collection_Practice cp = new Collection_Practice();
			
			depart.add(cp.new department("Sales", 34000, 15000));
			depart.add(cp.new department("Marketing", 20000, 5000));
			depart.add(cp.new department("Research", 30000, 20000));
			
			
			for(department d : depart) {
				System.out.println(d.getName() + " Department Profit: " +d.getProfit());
			}
			
			Collections.sort(depart, (d1, d2) -> Double.compare(d2.getProfit(), d1.getProfit()));
			System.out.println("Sorting Is Done.");
			
			for(department d : depart) {
				System.out.println(d.getName() + " Department Profit: " +d.getProfit());
			}
		}
	
}
