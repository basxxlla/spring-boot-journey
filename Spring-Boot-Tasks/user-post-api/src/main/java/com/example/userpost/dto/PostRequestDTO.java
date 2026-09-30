package com.example.userpost.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PostRequestDTO {

    @NotBlank(message = "Text is required")
    @Size(min = 20, message = "Text must be at least 20 characters")
    private String text;

    private String imagePath;

    @NotNull(message = "User ID is required")
    private Long userId;

    public PostRequestDTO() {
    }

    public PostRequestDTO(String text, String imagePath, Long userId) {
        this.text = text;
        this.imagePath = imagePath;
        this.userId = userId;
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
