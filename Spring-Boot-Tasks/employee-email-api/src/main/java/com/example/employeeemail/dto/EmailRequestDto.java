package com.example.employeeemail.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailRequestDto {

    @NotBlank(message = "name must not be null or empty")
    private String name; // email type, e.g. gmail, yahoo

    @NotBlank(message = "content must not be null or empty")
    @Email(message = "content must be a valid email pattern")
    private String content; // actual email address, e.g. eslam@gmail.com

    // Which employee this email belongs to. Only used by the standalone
    // "create Email" endpoint - ignored by the "employee with emails" endpoint,
    // where the employee is the one being created.
    private Long employeeId;
}
