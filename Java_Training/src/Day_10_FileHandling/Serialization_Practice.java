package Day_10_FileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	
	int bookCode;
	String bookName;
	
	public Book(int bookCode, String bookName) {
//		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
	}
	
}

public class Serialization_Practice {
	
	public static void main(String[] args) {
		
		Book b1 = new Book(101, "Java");
		
		try {
			FileOutputStream fo = new FileOutputStream("C:\\Users\\shiva\\OneDrive\\Desktop\\Eclipse\\Wipro_Training\\src\\Day_10_FileHandling\\Hi.txt");
			ObjectOutputStream out = new ObjectOutputStream(fo);
			out.writeObject(b1);
			
			fo.close();
			out.close();
			
			System.out.println("Complete Serialization.");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			
			ObjectInputStream io = new ObjectInputStream(new FileInputStream("C:\\Users\\shiva\\OneDrive\\Desktop\\Eclipse\\Wipro_Training\\src\\Day_10_FileHandling\\Hi.txt"));
			Book b2 = (Book) io.readObject();
			System.out.println("Book Code: " +b2.bookCode+ ", Book Name: " +b2.bookName);
			
			io.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
