package com.example.inheritance.tableperclass;

import javax.persistence.*;

// TABLE_PER_CLASS: each concrete subclass gets its own complete, independent
// table (all base + subclass fields duplicated). No joins needed for reads,
// but querying the abstract base type requires a UNION across tables, and
// ids are usually NOT shared/sequential across subclasses (each table often
// needs its own id generator - here we use TABLE strategy for portability).
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
