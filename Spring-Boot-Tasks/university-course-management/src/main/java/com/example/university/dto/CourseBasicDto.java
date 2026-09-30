package com.example.university.dto;

import com.example.university.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseBasicDto {
    private Long id;
    private String title;
    private String description;

    public static CourseBasicDto from(Course c) {
        return new CourseBasicDto(c.getId(), c.getTitle(), c.getDescription());
    }
}
