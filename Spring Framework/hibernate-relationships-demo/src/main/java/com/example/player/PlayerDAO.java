package com.example.player;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PlayerDAO {

    private final SessionFactory sessionFactory;

    public PlayerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // ---- CREATE ----
    public Long save(Player player) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.save(player);
            tx.commit();
            return player.getId();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    // ---- READ ----
    public Player getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Player.class, id);
        }
    }

    // ---- UPDATE ----
    public void update(Player player) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.update(player);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    // ---- DELETE ----
    public void delete(Long id) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            Player player = session.get(Player.class, id);
            if (player != null) {
                session.delete(player);
            }
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}
