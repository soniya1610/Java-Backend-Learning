import java.sql.*;

public class PreparedStatementDemo {

    public static void main(String[] args) {
        try {
            // Step 1: Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demodb",
                    "root",
                    "YOUR_PASSWORD");

            // Step 3: Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO employee (eid, name, age, salary) VALUES (?, ?, ?, ?)");

            // Insert Record 1
            ps.setString(1, "e1");
            ps.setString(2, "Bob");
            ps.setInt(3, 32);
            ps.setInt(4, 100000);
            ps.executeUpdate();

            // Insert Record 2
            ps.setString(1, "e2");
            ps.setString(2, "Shivam");
            ps.setInt(3, 26);
            ps.setInt(4, 34000);
            ps.executeUpdate();

            // Insert Record 3
            ps.setString(1, "e3");
            ps.setString(2, "Simran");
            ps.setInt(3, 25);
            ps.setInt(4, 15000);
            ps.executeUpdate();

            // Step 4: Close Connection
            con.close();

            System.out.println("Records inserted successfully!");

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("ID already exists!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}