package com.example.employeeemail.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

// Used by "create Employee with a list of email addresses and save all together"
@Data
public class EmployeeWithEmailsRequestDto {

    @NotBlank(message = "name must not be null or empty")
    private String name;

    @DecimalMin(value = "15", inclusive = false, message = "age must be greater than 15")
    @DecimalMax(value = "40", inclusive = false, message = "age must be less than 40")
    private int age;

    @DecimalMin(value = "5000", inclusive = false, message = "salary must be greater than 5000")
    @DecimalMax(value = "10000", inclusive = false, message = "salary must be less than 10000")
    private double salary;

    @NotEmpty(message = "emails list must not be empty")
    @Valid // cascades validation into each EmailRequestDto in the list
    private List<EmailRequestDto> emails;
}
