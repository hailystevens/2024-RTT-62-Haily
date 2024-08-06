package com.example.springboot.form;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateAccountFormBean {

    private Integer id;

    @Length(max = 150, message = "Email must be less than 150 characters")
    @NotEmpty(message = "Email is required.")
    private String email;

    @Length(max = 100, message = "Password must be less than 100 characters")
    @NotEmpty(message = "Password is required.")
    private String password;
}
