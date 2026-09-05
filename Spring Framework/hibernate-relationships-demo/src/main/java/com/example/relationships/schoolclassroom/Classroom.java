package com.example.relationships.schoolclassroom;

import javax.persistence.*;

@Entity
public class Classroom {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomNumber;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    public School getSchool() { return school; }
    public void setSchool(School school) { this.school = school; }
}
