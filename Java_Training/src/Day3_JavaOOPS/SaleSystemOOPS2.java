package Day3_JavaOOPS;

class SaleItem {
	 private String productName;
	 private double price;
	 private int quantity;

	 public SaleItem(String productName, double price, int quantity) {
	     this.productName = productName;
	     this.price = price;
	     this.quantity = quantity;
	 }

	 public String getProductName() {
	     return productName;
	 }

	 public double getPrice() {
	     return price;
	 }

	 public int getQuantity() {
	     return quantity;
	 }

	 public double getTotalCost() {
	     return price * quantity;
	 }
	}


	public class SaleSystemOOPS2 {
	 public static void main(String[] args) {
	     SaleItem item1 = new SaleItem("Pen", 10.0, 3);
	     SaleItem item2 = new SaleItem("Notebook", 50.0, 2);
	     SaleItem item3 = new SaleItem("Pencil", 5.0, 5);

	     System.out.println("Product\t \tPrice \tQuantity \tTotal");
	     System.out.println("------------------------------------------------");

	     System.out.println(item1.getProductName() + "\t\t" + item1.getPrice() + "\t" + item1.getQuantity() + "\t\t" + item1.getTotalCost());
	     System.out.println(item2.getProductName() + "\t\t" + item2.getPrice() + "\t" + item2.getQuantity() + "\t\t" + item2.getTotalCost());
	     System.out.println(item3.getProductName() + "\t\t" + item3.getPrice() + "\t" + item3.getQuantity() + "\t\t" + item3.getTotalCost());

	     double totalBill = item1.getTotalCost() + item2.getTotalCost() + item3.getTotalCost();

	     System.out.println("------------------------------------------------");
	     System.out.println("Total Bill Amount:\t\t\t" + totalBill);
	     System.out.println("------------------------------------------------");
	 }
	}