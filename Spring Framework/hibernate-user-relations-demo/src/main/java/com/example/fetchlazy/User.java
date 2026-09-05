package com.example.fetchlazy;

import javax.persistence.*;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    // fetch = LAZY: UserDetails is only loaded on first access, via a
    // separate SELECT, not as part of the initial query for User.
    //
    // Caveat: plain JPA/Hibernate proxies can only lazily load a @OneToOne
    // when the association is optional=false (so Hibernate knows it can
    // safely substitute a proxy instead of needing to check for null).
    // Without bytecode enhancement, marking it optional=true would silently
    // force Hibernate to fetch it eagerly anyway despite the LAZY annotation.
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_details_id", unique = true, nullable = false)
    private UserDetails userDetails;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public UserDetails getUserDetails() { return userDetails; }
    public void setUserDetails(UserDetails userDetails) { this.userDetails = userDetails; }
}
