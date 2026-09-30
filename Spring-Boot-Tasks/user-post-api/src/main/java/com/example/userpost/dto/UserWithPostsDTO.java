package com.example.userpost.dto;

import java.util.List;

public class UserWithPostsDTO {

    private Long id;
    private String name;
    private Integer age;
    private List<PostSummaryDTO> posts;

    public UserWithPostsDTO() {
    }

    public UserWithPostsDTO(Long id, String name, Integer age, List<PostSummaryDTO> posts) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<PostSummaryDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostSummaryDTO> posts) {
        this.posts = posts;
    }
}
