package com.example.university.dto;

import com.example.university.model.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructorDetailDto {
    private Long id;
    private String name;
    private String email;
    private List<CourseWithStudentsDto> courses;

    public static InstructorDetailDto from(Instructor i) {
        List<CourseWithStudentsDto> courses = i.getCourses().stream()
                .map(CourseWithStudentsDto::from)
                .collect(Collectors.toList());
        return new InstructorDetailDto(i.getId(), i.getName(), i.getEmail(), courses);
    }
}
