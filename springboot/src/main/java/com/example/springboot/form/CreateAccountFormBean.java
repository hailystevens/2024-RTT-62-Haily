package com.example.springboot.form;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateAccountFormBean {

    private Integer id;

    @Length(max = 150, message = "Email must be less than 150 characters")
    // Requirement: Form bean with 2 different validation annotations
    @NotEmpty(message = "Email is required.") // Requirement: Form bean with 2 different validation annotations
    private String email;

    @Length(max = 100, message = "Password must be less than 100 characters")
    // Requirement: Form bean with 2 different validation annotations
    @NotEmpty(message = "Password is required.") // Requirement: Form bean with 2 different validation annotations
    private String password;
}