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
    @NotEmpty(message = "Customer Name is required.")
    private String name;

    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email is required.")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be 10 digits")
    @NotEmpty(message = "Phone number is required.")
    private String phone;

    @Length(max = 255, message = "Billing address must be less than 255 characters")
    @NotEmpty(message = "Billing address is required.")
    private String billingAddress;

    @Length(max = 255, message = "Shipping address must be less than 255 characters")
    @NotEmpty(message = "Shipping address is required.")
    private String shippingAddress;
}
