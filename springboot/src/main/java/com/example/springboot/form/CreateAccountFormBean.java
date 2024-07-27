package com.example.springboot.form;

import com.example.springboot.validation.UniqueEmail;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountFormBean {

    @NotEmpty
    private String username;

    @NotEmpty
    @Email
    @UniqueEmail
    private String email;

    @NotEmpty
    private String password;
}
