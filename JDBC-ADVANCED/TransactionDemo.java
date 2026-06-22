import java.sql.*;

public class TransactionDemo {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demodb",
                    "root",
                    "YOUR_PASSWORD"
            );

            c.setAutoCommit(false);

            Statement st = c.createStatement();

            st.executeUpdate("update employee set age=19 where eid='e104'");
            st.executeUpdate("delete from employee where eid='e114'");

            ResultSet rs = st.executeQuery("select * from employee where eid='e104'");

            if (rs.next()) {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("age"));
            } else {
                System.out.println("No data found!");
            }

            int result = st.executeUpdate(
                    "update employee set name='Cheetah Thakur' where eid='e5'"
            );

            if (result == 0) {
                c.rollback();
                System.out.println("Transaction rolled back");
            } else {
                c.commit();
                System.out.println("Transaction committed");
            }

            ResultSet rs2 = st.executeQuery(
                    "select * from employee where eid='e104'"
            );

            if (rs2.next()) {
                System.out.println(rs2.getString("name"));
                System.out.println(rs2.getString("age"));
            } else {
                System.out.println("No data found!");
            }

            c.close();
            System.out.println("Thanks for using app");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
