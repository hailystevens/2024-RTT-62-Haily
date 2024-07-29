package com.example.springboot.form;

import com.example.springboot.validation.EmployeeEmailUnique;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class CreateEmployeeFormBean {

    private Integer id; // This field is used to determine if it's a create.jsp or edit operation

    @NotEmpty(message = "Email is required.")
    @Length(max = 100, message = "Email must be less than 100 characters")
    @EmployeeEmailUnique // Custom annotation for unique email validation
    private String email;

    @NotEmpty(message = "Last Name is required.")
    @Length(max = 50, message = "Last Name must be less than 50 characters")
    private String lastName;

    @NotEmpty(message = "First Name is required.")
    @Length(max = 50, message = "First Name must be less than 50 characters")
    private String firstName;

    private String extension;
    private String jobTitle;
    private Integer vacationHours;
    private String profileImageUrl;
    private Integer officeId;
    private Integer reportsTo;
    private MultipartFile file;
}
