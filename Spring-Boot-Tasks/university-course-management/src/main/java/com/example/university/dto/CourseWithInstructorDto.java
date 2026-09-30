package com.example.university.dto;

import com.example.university.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseWithInstructorDto {
    private Long id;
    private String title;
    private String description;
    private InstructorBasicDto instructor;

    public static CourseWithInstructorDto from(Course c) {
        return new CourseWithInstructorDto(
                c.getId(), c.getTitle(), c.getDescription(),
                InstructorBasicDto.from(c.getInstructor())
        );
    }
}
