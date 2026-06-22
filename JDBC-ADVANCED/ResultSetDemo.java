import java.sql.*;

public class ResultSetDemo {

    public static void main(String[] args) {
        try {
            // Step 1: Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demodb",
                    "root",
                    "YOUR_PASSWORD"
            );

            // Step 3: Create Statement
            Statement st = con.createStatement();

            // Step 4: Execute Query
            ResultSet rs = st.executeQuery("SELECT * FROM employee");

            // Step 5: Read Data from ResultSet
            while (rs.next()) {
                String id = rs.getString("eid");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double salary = rs.getDouble("salary");

                System.out.println(
                        "ID: " + id +
                        ", Name: " + name +
                        ", Age: " + age +
                        ", Salary: " + salary
                );
            }

            // Step 6: Close Connection
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
