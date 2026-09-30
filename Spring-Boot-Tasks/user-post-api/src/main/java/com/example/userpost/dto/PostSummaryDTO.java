package com.example.userpost.dto;

public class PostSummaryDTO {

    private Long id;
    private String text;
    private String imagePath;

    public PostSummaryDTO() {
    }

    public PostSummaryDTO(Long id, String text, String imagePath) {
        this.id = id;
        this.text = text;
        this.imagePath = imagePath;
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
}
