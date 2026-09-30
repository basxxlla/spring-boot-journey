package com.example.teacherstudent.dto;

import java.util.Set;

public class StudentDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String grade;
    private Set<TeacherSummaryDTO> teachers;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String firstName, String lastName, String email, String grade, Set<TeacherSummaryDTO> teachers) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.grade = grade;
        this.teachers = teachers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Set<TeacherSummaryDTO> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<TeacherSummaryDTO> teachers) {
        this.teachers = teachers;
    }
}
