package Day_14_JDBC_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Transaction_Handling {
	
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
        
        try {
        	Connection con = DriverManager.getConnection(url, username, password);
        	con.setAutoCommit(false);
        	String debitQuery = "update bank set balance = balance - ? where acc_number = ?";
        	String creditQuery = "update bank set balance = balance + ? where acc_number = ?";
        	
        	PreparedStatement debitPS = con.prepareStatement(debitQuery);
        	PreparedStatement creditPS = con.prepareStatement(creditQuery);
        	Scanner sc = new Scanner(System.in);
        	System.out.print("Enter account number(withdraw): ");
        	int acc_number = sc.nextInt();
        	System.out.print("Enter the amount to deduct: ");
        	double amount = sc.nextDouble();
        	
        	
        	debitPS.setDouble(1, amount);
        	debitPS.setInt(2, acc_number);
        	
        	creditPS.setDouble(1, amount);
        	creditPS.setInt(2, 102);
        	
        	debitPS.executeUpdate();
        	creditPS.executeUpdate();
        	
        	if(isSufficient(con, acc_number, amount)) {
        		con.commit();
        		System.out.println("Transaction Successful.");
        	}
        	else {
        		con.rollback();
        		System.out.println("Transaction Failed!!!");
        	}
        	
        	debitPS.close();
        	creditPS.close();
        	con.close();
        	sc.close();
        	
        }
        
        catch(SQLException e) {
        	e.printStackTrace();
        }
        
	}
	
	static boolean isSufficient(Connection con, int acc_number, double amount) {
		try {
			String query = "select balance from bank where acc_number = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, acc_number);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				double current_balance = rs.getDouble("balance");
				if(amount > current_balance) {
					return false;
				} 
				else {
					return true;
				}
			}
			
			ps.close();
			rs.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
