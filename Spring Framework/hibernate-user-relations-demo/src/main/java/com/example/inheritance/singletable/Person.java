package com.example.inheritance.singletable;

import javax.persistence.*;

// SINGLE_TABLE (Hibernate's default if @Inheritance is omitted): all
// subclasses share ONE physical table, with a discriminator column
// distinguishing rows. Fastest reads (no joins), but subclass-only columns
// must be nullable.
@Entity
@Table(name = "person_single_table")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
