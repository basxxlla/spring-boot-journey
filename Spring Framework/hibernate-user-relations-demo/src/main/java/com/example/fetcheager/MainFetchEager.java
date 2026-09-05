package com.example.fetcheager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainFetchEager {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-fetcheager.cfg.xml")
                .buildSessionFactory();

        // ---- setup: save a User with UserDetails ----
        Long userId;
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            UserDetails details = new UserDetails();
            details.setAddress("123 Main St");
            details.setPhone("555-1234");

            User user = new User();
            user.setName("Ahmed");
            user.setAge(25);
            user.setUserDetails(details);

            session.save(user);
            tx.commit();
            userId = user.getId();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }

        // ---- get data, then close the session BEFORE touching userDetails ----
        Session session2 = sessionFactory.openSession();
        User user = session2.get(User.class, userId); // userDetails is already loaded here (JOIN)
        session2.close();

        System.out.println("\n--- Fetch: after session is closed ---");
        // No LazyInitializationException here - userDetails was already
        // fully loaded as part of the original query, so it's safe to use
        // even though the session is now closed.
        System.out.println("User: " + user.getName());
        System.out.println("Address: " + user.getUserDetails().getAddress());
        System.out.println("Phone: " + user.getUserDetails().getPhone());

        sessionFactory.close();
    }
}
