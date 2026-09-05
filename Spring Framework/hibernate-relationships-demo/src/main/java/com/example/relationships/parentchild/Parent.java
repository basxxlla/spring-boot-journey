package com.example.relationships.parentchild;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Relationship: ONE-TO-MANY (simplified model: one parent record has many
// children). Real family trees usually have two parents per child, which
// would require Child MANY-TO-MANY Parent instead - simplified here for clarity.
@Entity
public class Parent {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Child> children = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Child> getChildren() { return children; }
    public void setChildren(List<Child> children) { this.children = children; }
}
