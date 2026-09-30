package com.example.userpost.dto;

public class PostWithUserDTO {

    private Long id;
    private String text;
    private String imagePath;
    private UserResponseDTO user;

    public PostWithUserDTO() {
    }

    public PostWithUserDTO(Long id, String text, String imagePath, UserResponseDTO user) {
        this.id = id;
        this.text = text;
        this.imagePath = imagePath;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        this.user = user;
    }
}
