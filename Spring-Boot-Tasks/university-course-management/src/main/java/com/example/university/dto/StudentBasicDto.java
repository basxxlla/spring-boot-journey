package com.example.university.dto;

import com.example.university.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentBasicDto {
    private Long id;
    private String name;
    private String email;

    public static StudentBasicDto from(Student s) {
        return new StudentBasicDto(s.getId(), s.getName(), s.getEmail());
    }
}
