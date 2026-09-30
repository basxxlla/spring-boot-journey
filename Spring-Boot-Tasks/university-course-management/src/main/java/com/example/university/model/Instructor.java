package com.example.university.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
@Getter
@Setter
@NoArgsConstructor
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    // An instructor can teach many courses - One-to-Many, inverse side
    // (Course owns the FK). Lazy by default, and NOT included in
    // equals/hashCode/toString (Lombok @Getter/@Setter only, no @Data) to
    // avoid infinite recursion through the bidirectional relationship.
    @OneToMany(mappedBy = "instructor")
    private List<Course> courses = new ArrayList<>();

    public Instructor(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
