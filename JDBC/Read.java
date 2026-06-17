import java.sql.*;

public class Read {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demodb",
                    "root",
                    "YOUR_PASSWORD"
            );

            Statement st = c.createStatement();

            ResultSet rs = st.executeQuery(
                    "select * from employee where eid = 'e101'"
            );

            if (rs.next()) {
                String n = rs.getString("name");
                System.out.println("Employee Name: " + n);
            } else {
                System.out.println("No data found!");
            }

            c.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}