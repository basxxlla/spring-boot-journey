package com.example.inheritance.singletable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainSingleTable {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-inheritance-singletable.cfg.xml")
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

            // querying the abstract base type returns both subclasses -
            // all backed by the single "person_single_table" table
            List<Person> people = session.createQuery("from Person", Person.class).list();
            System.out.println("SINGLE_TABLE strategy - all people in one table:");
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
