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
    }

