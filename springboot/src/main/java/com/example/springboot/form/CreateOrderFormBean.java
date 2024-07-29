package com.example.springboot.form;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CreateOrderFormBean {

    private Integer id; // This field is used to determine if it's a create or edit operation

    @NotNull(message = "Customer ID is required.")
    private Integer customerId;

    private LocalDateTime orderDate;
    private LocalDateTime requiredDate;
    private LocalDateTime shippedDate;
    private String status;
    private String comments;
}
