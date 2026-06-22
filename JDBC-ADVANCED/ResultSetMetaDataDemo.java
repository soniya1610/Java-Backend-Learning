import java.sql.*;

public class ResultSetMetaDataDemo {

    public static void main(String[] args) {
        try {
            // Step 1: Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demodb",
                    "root",
                    "YOUR_PASSWORD"
            );

            // Step 3: Create Statement
            Statement st = con.createStatement();

            // Step 4: Execute Query
            ResultSet rs = st.executeQuery("SELECT * FROM employee");

            // Step 5: Get Metadata
            ResultSetMetaData metaData = rs.getMetaData();

            System.out.println("Total Columns: " + metaData.getColumnCount());
            System.out.println("3rd Column Name: " + metaData.getColumnName(3));
            System.out.println("3rd Column Type: " + metaData.getColumnTypeName(3));

            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
