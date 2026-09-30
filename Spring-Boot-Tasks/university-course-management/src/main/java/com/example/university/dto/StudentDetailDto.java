package com.example.university.dto;

import com.example.university.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetailDto {
    private Long id;
    private String name;
    private String email;
    private List<CourseWithInstructorDto> courses;

    public static StudentDetailDto from(Student s) {
        List<CourseWithInstructorDto> courses = s.getCourses().stream()
                .map(CourseWithInstructorDto::from)
                .collect(Collectors.toList());
        return new StudentDetailDto(s.getId(), s.getName(), s.getEmail(), courses);
    }
}
