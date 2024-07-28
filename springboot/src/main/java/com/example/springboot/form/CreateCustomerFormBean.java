package com.example.springboot.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCustomerFormBean {
    private Integer id;

    @NotEmpty(message = "Customer name is required")
    private String customerName;

    @NotEmpty(message = "Contact first name is required")
    private String contactFirstname;

    @NotEmpty(message = "Contact last name is required")
    private String contactLastname;

    @NotEmpty(message = "Phone is required")
    @Pattern(regexp = "\\+?[0-9. ()-]{7,25}", message = "Phone number is invalid")
    private String phone;

    @NotEmpty(message = "Address Line 1 is required")
    private String addressLine1;

    private String addressLine2;

    @NotEmpty(message = "City is required")
    private String city;

    @NotEmpty(message = "State is required")
    private String state;

    @NotEmpty(message = "Postal code is required")
    private String postalCode;

    @NotEmpty(message = "Country is required")
    private String country;

    @NotNull(message = "Credit limit is required")
    private Double creditLimit;

    @NotNull(message = "Sales representative employee ID is required")
    private Integer salesRepEmployeeId;
}
