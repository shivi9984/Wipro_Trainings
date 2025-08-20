package Day_13_JDBC;

import java.sql.*;

public class JDBC_Demo2 {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/training";
        String username = "root";
        String password = "Shivam@9984";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement st = con.createStatement()) {

            String tableQuery = "create table demo2(id int NOT NULL auto_increment primary key, name varchar(30) NOT NULL, age int NOT NULL)";
            st.executeUpdate(tableQuery);
            System.out.println("Table Created Successfully...");

            String insertQuery = "insert into demo2(name, age) values(?,?)";

            try (PreparedStatement ps = con.prepareStatement(insertQuery)) {
                ps.setString(1, "Ayush");
                ps.setInt(2, 25);
                ps.addBatch();
                int[] arr = ps.executeBatch();
    //          All the rows inserted into the database at a single batch.
                
                System.out.printf("Inserted rows: %d%n", (int) java.util.stream.IntStream.of(arr).filter(c -> c > 0).count());
   //           This print line is used get rows affected in database.
            }
            

            String query = "select * from demo2";
            try (ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    System.out.println("ID: " + id + " Name: " + name + " Age: " + age);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

