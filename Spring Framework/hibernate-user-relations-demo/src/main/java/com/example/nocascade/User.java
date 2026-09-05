package com.example.nocascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// NOTE: no cascade attribute anywhere below - each associated entity must be
// saved explicitly / independently by the caller.
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    // User has only one UserDetails - One-to-One, User owns the FK
    @OneToOne
    @JoinColumn(name = "user_details_id", unique = true)
    private UserDetails userDetails;

    // User has many Friends / Friends has many User - Many-to-Many, User owns the join table
    @ManyToMany
    @JoinTable(
            name = "user_friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<Friends> friends = new ArrayList<>();

    // User has many Post - One-to-Many, inverse side (Post owns the FK)
    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public UserDetails getUserDetails() { return userDetails; }
    public void setUserDetails(UserDetails userDetails) { this.userDetails = userDetails; }
    public List<Friends> getFriends() { return friends; }
    public void setFriends(List<Friends> friends) { this.friends = friends; }
    public List<Post> getPosts() { return posts; }
    public void setPosts(List<Post> posts) { this.posts = posts; }
}
