package com.example.fetchlazy;

import org.hibernate.LazyInitializationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainFetchLazy {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-fetchlazy.cfg.xml")
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

        // ---- 1. get data WITHIN the same session: lazy loading works fine ----
        // Watch the SQL logs: the first SELECT loads only the User row.
        // A second SELECT for user_details only fires when getUserDetails()
        // is actually touched below.
        Session session1 = sessionFactory.openSession();
        System.out.println("\n--- Fetch #1: inside an open session ---");
        User userInSession = session1.get(User.class, userId);
        System.out.println("Loaded User: " + userInSession.getName() + " (no user_details query yet)");
        System.out.println("Now accessing userDetails...");
        System.out.println("Address: " + userInSession.getUserDetails().getAddress()); // triggers 2nd SELECT
        session1.close();

        // ---- 2. get data AFTER the session is closed: fails ----
        Session session2 = sessionFactory.openSession();
        User userOutsideSession = session2.get(User.class, userId);
        session2.close(); // session closed BEFORE we touch userDetails

        System.out.println("\n--- Fetch #2: after session is closed ---");
        try {
            System.out.println("Address: " + userOutsideSession.getUserDetails().getAddress());
        } catch (LazyInitializationException e) {
            System.out.println("Got LazyInitializationException as expected: " + e.getMessage());
        }

        sessionFactory.close();
    }
}
