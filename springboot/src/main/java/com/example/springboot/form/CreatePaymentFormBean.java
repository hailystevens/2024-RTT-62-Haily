package com.example.springboot.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@ToString
public class CreatePaymentFormBean {

    private Integer id;

    @NotNull(message = "Customer ID is required")
    private Integer customerId;

    @NotEmpty(message = "Check number is required")
    private String checkNumber;

    @NotEmpty(message = "Payment date is required")
    private String paymentDate;

    @NotNull(message = "Amount is required")
    private Double amount;

    public void setPaymentDate(Date paymentDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.paymentDate = dateFormat.format(paymentDate);
    }
}
