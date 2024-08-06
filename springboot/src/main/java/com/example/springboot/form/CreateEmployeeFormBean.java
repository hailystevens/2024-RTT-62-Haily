package com.example.springboot.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class CreateEmployeeFormBean {

    private Integer id;

    @Length(max = 100, message = "Email must be less than 100 characters")
    @NotEmpty(message = "Email is required.")
    private String email;

    @Length(max = 50, message = "Last Name must be less than 50 characters")
    @NotEmpty(message = "Last Name is required.")
    private String lastName;

    @Length(max = 50, message = "First Name must be less than 50 characters")
    @NotEmpty(message = "First Name is required.")
    private String firstName;

    private String extension;
    private String jobTitle;
    private Integer vacationHours;
    private String profileImageUrl;
    private Integer officeId;
    private Integer reportsTo;

    private MultipartFile file;
}
