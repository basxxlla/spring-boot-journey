package com.example.relationships.bookauthor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Relationship: MANY-TO-MANY (a book can have several co-authors; an author
// can write several books). If you only ever need a single author per book,
// this could instead be modeled as Book MANY-TO-ONE Author.
@Entity
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public List<Author> getAuthors() { return authors; }
    public void setAuthors(List<Author> authors) { this.authors = authors; }
}
