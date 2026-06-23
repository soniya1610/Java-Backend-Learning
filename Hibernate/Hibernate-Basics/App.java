/*
 * App.java is the main class used to run the Hibernate application.
 * It loads Hibernate configuration, creates Session/Transaction,
 * and performs database operations like insert, update, delete, and read.
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure();
        // cfg.configure("soniya.xml"); // for custom config file
        cfg.addAnnotatedClass(Book.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction txn = session.beginTransaction();

        Book book = new Book();
        book.setName("Advanced Java");
        book.setPrice(10000);
        book.setAuthor("Rahul Chauhan");

        session.persist(book);

        txn.commit();

        System.out.println("Success");

        session.close();
        sessionFactory.close();
    }
}
