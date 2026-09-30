package com.example.university.dto;

import com.example.university.model.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructorBasicDto {
    private Long id;
    private String name;
    private String email;

    public static InstructorBasicDto from(Instructor i) {
        if (i == null) return null;
        return new InstructorBasicDto(i.getId(), i.getName(), i.getEmail());
    }
}
