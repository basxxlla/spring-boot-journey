package com.example.inheritance.joined;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainJoined {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-inheritance-joined.cfg.xml")
                .buildSessionFactory();

        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            Employee emp = new Employee();
            emp.setName("Ahmed");
            emp.setSalary(5000);
            session.save(emp);

            Customer cust = new Customer();
            cust.setName("Sara");
            cust.setDiscountRate(0.1);
            session.save(cust);

            tx.commit();

            // Hibernate generates a SQL JOIN between person_joined and
            // employee_joined/customer_joined to load each subclass.
            List<Person> people = session.createQuery("from Person", Person.class).list();
            System.out.println("JOINED strategy - one table per class, joined by shared PK:");
            for (Person p : people) {
                System.out.println("  - " + p.getClass().getSimpleName() + ": " + p.getName());
            }
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }

        sessionFactory.close();
    }
}
