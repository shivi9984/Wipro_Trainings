package Day_13_JDBC;

import java.sql.*;

public class Prepared_Practice {
	
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
			String insertQuery = "insert into demo2(name, age) values(?, ?);";
			
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, "Shivam");
			ps.setInt(2, 24);
			ps.addBatch();
			
			ps.setString(1, "Manglam");
			ps.setInt(2, 26);
			ps.addBatch();
			
			int[] result = ps.executeBatch();
			System.out.println("Inserted Rows: " +result.length);
			
			String query = "select * from demo2";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				System.out.println("ID: " +id+ ", NAME: " +name+ ", AGE: " +age);
			}
			
			con.close();
			ps.close();
			st.close();
			rs.close();
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
