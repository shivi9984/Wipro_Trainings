package Day_14_JDBC_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Batch_With_PreparedStatement {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/training";
        String username = "root";
        String password = "Shivam@9984";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try{
			Connection con = DriverManager.getConnection(url, username, password);
			String query = "insert into demo2(name, age) values(?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			Scanner sc = new Scanner(System.in);
			while(true){
                System.out.print("Enter name: ");
                String name = sc.next();
                sc.nextLine();
                System.out.print("Enter age: ");
                int age = sc.nextInt();

                System.out.print("You want to add more values YES/NO: ");
                String decision = sc.next();
                
                ps.setString(1, name);
                ps.setInt(2, age);
                ps.addBatch();
                
                if (decision.toUpperCase().equals("NO")){
                    break;
                }
            }
			
			int[] rowsAffected = ps.executeBatch();
			for(int i=0; i<rowsAffected.length; i++) {
				if(rowsAffected[i] == 0) {
					System.out.println("Query: " +i+ "not executed successfully.");
				}
				else {
					System.out.println("All queries executed.");
				}
			}
			
			sc.close();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
