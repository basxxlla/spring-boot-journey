package com.example.withcascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

/**
 * Cascade IS configured on every relationship in this package's User entity
 * (@OneToOne / @ManyToMany / @OneToMany all carry cascade). That means we
 * only need to call session.save(user) once - Hibernate automatically
 * persists the brand-new UserDetails, Friends, and Post objects reachable
 * from it.
 */
public class MainWithCascade {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-withcascade.cfg.xml")
                .buildSessionFactory();

        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            User user = new User();
            user.setName("Ahmed");
            user.setAge(25);

            // ---------- 1. add User with UserDetails (One-to-One) ----------
            UserDetails details = new UserDetails();
            details.setAddress("123 Main St");
            details.setPhone("555-1234");
            user.setUserDetails(details); // not saved yet - cascade will handle it

            // ---------- 2. add User with Friends (Many-to-Many) ----------
            Friends f1 = new Friends();
            f1.setName("Sara");
            Friends f2 = new Friends();
            f2.setName("Omar");
            user.setFriends(Arrays.asList(f1, f2)); // not saved yet - cascade will handle it

            // ---------- 3. add User with Post (One-to-Many) ----------
            Post p1 = new Post();
            p1.setHeader("Hello World");
            p1.setContent("My first post");
            p1.setUser(user);

            Post p2 = new Post();
            p2.setHeader("Second Post");
            p2.setContent("Another update");
            p2.setUser(user);

            user.setPosts(Arrays.asList(p1, p2)); // not saved yet - cascade will handle it

            // ONE call does it all thanks to cascade:
            session.save(user);

            tx.commit();

            System.out.println("Saved User id=" + user.getId()
                    + " with UserDetails id=" + details.getId()
                    + ", " + user.getFriends().size() + " friends, and "
                    + user.getPosts().size() + " posts (all via cascade from a single save(user)).");
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }

        sessionFactory.close();
    }
}
