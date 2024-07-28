package com.example.springboot.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetailsBean {
    private Integer orderId;
    private Integer productId;
    private Integer quantityOrdered;
    private String productName;
    private Double priceEach;
    private String total;
}
