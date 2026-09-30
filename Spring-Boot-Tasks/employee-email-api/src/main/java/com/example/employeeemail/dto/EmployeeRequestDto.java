package com.example.employeeemail.dto;

import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

@Data
public class EmployeeRequestDto {

    @NotBlank(message = "name must not be null or empty")
    private String name;

    // strictly greater than 15 and strictly less than 40
    @DecimalMin(value = "15", inclusive = false, message = "age must be greater than 15")
    @DecimalMax(value = "40", inclusive = false, message = "age must be less than 40")
    private int age;

    // strictly greater than 5000 and strictly less than 10000
    @DecimalMin(value = "5000", inclusive = false, message = "salary must be greater than 5000")
    @DecimalMax(value = "10000", inclusive = false, message = "salary must be less than 10000")
    private double salary;
}
