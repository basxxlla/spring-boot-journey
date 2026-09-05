package com.example.inheritance.tableperclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainTablePerClass {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-inheritance-tableperclass.cfg.xml")
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

            // Hibernate runs a UNION ALL across employee_tpc and customer_tpc
            // to satisfy a query against the abstract Person type.
            List<Person> people = session.createQuery("from Person", Person.class).list();
            System.out.println("TABLE_PER_CLASS strategy - fully separate tables, UNION on read:");
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
