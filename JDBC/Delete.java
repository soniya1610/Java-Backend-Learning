import java.sql.*;

public class Delete {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demodb",
                    "root",
                    "YOUR_PASSWORD"
            );

            Statement st = c.createStatement();

            // Warning: deletes all records
            int count = st.executeUpdate("delete from employee");

            c.close();

            if (count == 0) {
                System.out.println("No data found");
            } else {
                System.out.println("Success!");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
