package com.example.nocascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

/**
 * No cascade is configured on any relationship in this package's User entity.
 * That means: every related entity (UserDetails, Friends, Post) must be saved
 * explicitly by the caller BEFORE (or as part of, on its own) the same
 * transaction - Hibernate will not auto-persist them just because they're
 * referenced from User.
 */
public class MainNoCascade {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-nocascade.cfg.xml")
                .buildSessionFactory();

        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            // ---------- 1. add User with UserDetails (One-to-One) ----------
            // Must save UserDetails first - User only stores its FK.
            UserDetails details = new UserDetails();
            details.setAddress("123 Main St");
            details.setPhone("555-1234");
            session.save(details); // explicit save - no cascade will do this for us

            User user = new User();
            user.setName("Ahmed");
            user.setAge(25);
            user.setUserDetails(details);
            session.save(user); // saving User does NOT cascade-save details (already saved above)

            // ---------- 2. add User with Friends (Many-to-Many) ----------
            // Must save each Friends row first - User's join table insert only
            // works once the referenced Friends rows already have an id.
            Friends f1 = new Friends();
            f1.setName("Sara");
            session.save(f1);

            Friends f2 = new Friends();
            f2.setName("Omar");
            session.save(f2);

            user.setFriends(Arrays.asList(f1, f2));
            session.update(user); // re-sync user's collection -> inserts user_friends join rows

            // ---------- 3. add User with Post (One-to-Many / Many-to-One) ----------
            // Post owns the FK, so each Post must be saved explicitly with the
            // user reference already set - no cascade needed here either since
            // we're not relying on User's collection to persist Post for us.
            Post p1 = new Post();
            p1.setHeader("Hello World");
            p1.setContent("My first post");
            p1.setUser(user);
            session.save(p1);

            Post p2 = new Post();
            p2.setHeader("Second Post");
            p2.setContent("Another update");
            p2.setUser(user);
            session.save(p2);

            tx.commit();

            System.out.println("Saved User id=" + user.getId()
                    + " with UserDetails id=" + details.getId()
                    + ", " + user.getFriends().size() + " friends, and 2 posts (no cascade used).");
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }

        sessionFactory.close();
    }
}
