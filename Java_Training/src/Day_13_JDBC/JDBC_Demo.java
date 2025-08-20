package Day_13_JDBC;

// 1. Import Package
// 2. Load and register the driver
// 3. Establish the connection
// 4. Create the statements
// 5. Execute the query
// 6. Process result
// 7. Close the connection

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBC_Demo {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost:3306/training";
        String username = "root";
        String password = "Shivam@9984";
        
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded Successfully.");

	
		String query = "select * from demo";
					
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String name = rs.getString("Name");
			
			System.out.println("ID: " +id+ " Name: " +name);
		}
		
		con.close();
		st.close();
		rs.close();
		
		
	}
}
