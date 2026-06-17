import java.sql.*;

public class Insert {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demodb",
                    "root",
                    "YOUR_PASSWORD"
            );

            Statement st = c.createStatement();

            st.executeUpdate(
                "insert into employee (eid, name, salary) values ('e109','Shyam',100000)"
            );

            st.executeUpdate(
                "insert into employee values ('e102','Ram',1000000,20)"
            );

            c.close();
            System.out.println("Success!");

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Id already exists");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}