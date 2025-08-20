package Day_13_JDBC;

import java.sql.*;

public class JDBC_Insert {
	
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
        	String insertQuery = "insert into demo(Name) values('Raj');";
        	
        	Connection con = DriverManager.getConnection(url, username, password);
        	Statement st = con.createStatement();
        	int rows = st.executeUpdate(insertQuery);
        	
        	if(rows > 0) {
        		System.out.println("Data Inserted Successfully.");
        	}
        	else {
        		System.out.println("Insertion Failed!!!.");
        	}
        	
        	con.close();
        	st.close();
        	
        }
        catch(SQLException e) {
        	e.printStackTrace();
        }
        
       
	}
}
