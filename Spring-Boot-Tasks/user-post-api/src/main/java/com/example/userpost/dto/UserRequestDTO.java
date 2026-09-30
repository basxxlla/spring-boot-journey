package com.example.userpost.dto;

import jakarta.validation.constraints.*;

public class UserRequestDTO {

    @NotBlank(message = "Name is required")
    @Size(min = 8, message = "Name must be greater than 7 characters")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be 18 or greater")
    private Integer age;

    @NotBlank(message = "Password is required")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#^()_+=\\-{}\\[\\]|:;\"'<>,./\\\\]).{8,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character"
    )
    private String password;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String name, Integer age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
