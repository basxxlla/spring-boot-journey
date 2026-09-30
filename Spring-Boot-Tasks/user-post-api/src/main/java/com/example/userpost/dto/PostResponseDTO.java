package com.example.userpost.dto;

public class PostResponseDTO {

    private Long id;
    private String text;
    private String imagePath;
    private Long userId;

    public PostResponseDTO() {
    }

    public PostResponseDTO(Long id, String text, String imagePath, Long userId) {
        this.id = id;
        this.text = text;
        this.imagePath = imagePath;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
