package com.example;

import com.example.model.Teacher;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();

            Teacher teacher = new Teacher("John Smith", 18, "123 Main Street");
            session.save(teacher);

            tx.commit();

            System.out.println("Saved: " + teacher);
        } finally {
            HibernateUtil.shutdown();
        }
    }
}
