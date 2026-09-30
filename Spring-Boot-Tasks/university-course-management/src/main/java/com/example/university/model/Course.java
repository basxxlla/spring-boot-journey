package com.example.university.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    // A course is taught by one instructor - Many-to-One, owning side (FK lives here)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    // A course can have many students - inverse side of the Many-to-Many
    // (Student owns the join table via @JoinTable)
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    public Course(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
