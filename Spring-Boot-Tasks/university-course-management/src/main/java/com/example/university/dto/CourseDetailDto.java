package com.example.university.dto;

import com.example.university.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDetailDto {
    private Long id;
    private String title;
    private String description;
    private InstructorBasicDto instructor;
    private List<StudentBasicDto> students;

    public static CourseDetailDto from(Course c) {
        List<StudentBasicDto> students = c.getStudents().stream()
                .map(StudentBasicDto::from)
                .collect(Collectors.toList());
        return new CourseDetailDto(
                c.getId(), c.getTitle(), c.getDescription(),
                InstructorBasicDto.from(c.getInstructor()),
                students
        );
    }
}
