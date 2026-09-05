package com.example.relationships.bookauthor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

/**
 * Demonstrates a Many-to-Many relationship (Book <-> Author) end to end:
 *   1. SAVE  - create Author instances, create Book instances, link them, save both.
 *   2. FETCH/PRINT - read from the Book side (see its Authors) and from the
 *      Author side (see their Books) to prove the link works both ways.
 */
public class MainBookAuthor {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-bookauthor.cfg.xml")
                .buildSessionFactory();

        Long book1Id;
        Long author1Id;

        // ==================== 1. SAVE (both models) ====================
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            // -- save from Author model --
            Author author1 = new Author();
            author1.setName("J.K. Rowling");
            session.save(author1);

            Author author2 = new Author();
            author2.setName("John Tiffany");
            session.save(author2);

            // -- save from Book model, linking both authors --
            Book book1 = new Book();
            book1.setTitle("Harry Potter and the Cursed Child");
            book1.setAuthors(Arrays.asList(author1, author2)); // many-to-many link

            Book book2 = new Book();
            book2.setTitle("Harry Potter and the Philosopher's Stone");
            book2.setAuthors(Arrays.asList(author1)); // linked to author1 only

            session.save(book1);
            session.save(book2);

            tx.commit();

            book1Id = book1.getId();
            author1Id = author1.getId();

            System.out.println("Saved Book '" + book1.getTitle() + "' (id=" + book1Id + ")");
            System.out.println("Saved Book '" + book2.getTitle() + "' (id=" + book2.getId() + ")");
            System.out.println("Saved Author '" + author1.getName() + "' (id=" + author1Id + ")");
            System.out.println("Saved Author '" + author2.getName() + "' (id=" + author2.getId() + ")");
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }

        // ==================== 2. FETCH / PRINT from Book side ====================
        try (Session session = sessionFactory.openSession()) {
            Book fetchedBook = session.get(Book.class, book1Id);
            System.out.println("\n--- Fetched from Book side ---");
            System.out.println("Book: " + fetchedBook.getTitle());
            System.out.println("Authors of this book:");
            for (Author a : fetchedBook.getAuthors()) {
                System.out.println("  - " + a.getName());
            }
        }

        // ==================== 2. FETCH / PRINT from Author side ====================
        try (Session session = sessionFactory.openSession()) {
            Author fetchedAuthor = session.get(Author.class, author1Id);
            System.out.println("\n--- Fetched from Author side ---");
            System.out.println("Author: " + fetchedAuthor.getName());
            System.out.println("Books by this author:");
            for (Book b : fetchedAuthor.getBooks()) {
                System.out.println("  - " + b.getTitle());
            }
        }

        sessionFactory.close();
    }
}
