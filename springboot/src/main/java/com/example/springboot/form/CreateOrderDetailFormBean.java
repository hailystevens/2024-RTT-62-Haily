package com.example.springboot.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateOrderDetailFormBean {

    private Integer id;
    private Integer orderId;
    private Integer productId;
    private Integer quantityOrdered;
    private Double priceEach;
    private Short orderLineNumber;
}
