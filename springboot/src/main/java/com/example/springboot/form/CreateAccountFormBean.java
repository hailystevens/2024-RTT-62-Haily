package com.example.springboot.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateAccountFormBean {
    private Integer id;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Password is required")
    @Size(min = 6, message = "Password should be at least 6 characters")
    private String password;

    @NotEmpty(message = "First name is required")
    private String firstname;

    @NotEmpty(message = "Last name is required")
    private String lastname;
}
