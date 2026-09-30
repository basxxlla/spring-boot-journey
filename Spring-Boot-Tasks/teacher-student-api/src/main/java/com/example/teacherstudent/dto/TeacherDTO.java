package com.example.teacherstudent.dto;

import java.util.Set;

public class TeacherDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String subject;
    private Set<StudentSummaryDTO> students;

    public TeacherDTO() {
    }

    public TeacherDTO(Long id, String firstName, String lastName, String email, String subject, Set<StudentSummaryDTO> students) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.subject = subject;
        this.students = students;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<StudentSummaryDTO> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentSummaryDTO> students) {
        this.students = students;
    }
}
