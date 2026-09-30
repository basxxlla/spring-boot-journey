package com.example.employeeemail.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailResponseDto {
    private Long id;
    private String name;
    private String content;
    private Long employeeId;
}
