package com.example.springboot.form;

import com.example.springboot.database.entity.ProductLine;
import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@ToString
public class CreateProductFormBean {

    private Integer id;

    @NotEmpty(message = "Product code is required")
    private String productCode;

    @NotEmpty(message = "Product name is required")
    private String productName;

    private Integer productlineId;

    @NotEmpty(message = "Product scale is required")
    private String productScale;

    @NotEmpty(message = "Product vendor is required")
    private String productVendor;

    private String productDescription;

    @NotNull(message = "Quantity in stock is required")
    private Integer quantityInStock;

    @NotNull(message = "Buy price is required")
    private Double buyPrice;

    @NotNull(message = "MSRP is required")
    private Double msrp;

    public void setProductLineId(ProductLine productLine) {
    }
}
