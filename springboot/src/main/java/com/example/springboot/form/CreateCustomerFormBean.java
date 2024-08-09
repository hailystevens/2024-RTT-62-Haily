package com.example.springboot.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class CreateCustomerFormBean {

    private Integer id;

    @Length(max = 50, message = "Customer Name must be less than 50 characters")
    // Requirement: Form bean with 2 different validation annotations
    @NotEmpty(message = "Customer Name is required.") // Requirement: Form bean with 2 different validation annotations
    private String name;

    @Email(message = "Email should be valid") // Requirement: Form bean with 2 different validation annotations
    @NotEmpty(message = "Email is required.") // Requirement: Form bean with 2 different validation annotations
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be 10 digits")
    // Requirement: Form bean with 2 different validation annotations
    @NotEmpty(message = "Phone number is required.") // Requirement: Form bean with 2 different validation annotations
    private String phone;

    @Length(max = 255, message = "Billing address must be less than 255 characters")
    // Requirement: Form bean with 2 different validation annotations
    @NotEmpty(message = "Billing address is required.")
    // Requirement: Form bean with 2 different validation annotations
    private String billingAddress;

    @Length(max = 255, message = "Shipping address must be less than 255 characters")
    // Requirement: Form bean with 2 different validation annotations
    @NotEmpty(message = "Shipping address is required.")
    // Requirement: Form bean with 2 different validation annotations
    private String shippingAddress;
}
