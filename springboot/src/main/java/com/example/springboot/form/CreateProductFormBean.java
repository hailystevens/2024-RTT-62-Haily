package com.example.springboot.form;

import lombok.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class CreateProductFormBean {
    private Integer id;

    @Length(max = 70, message = "Product Name must be less than 50 characters")
    @NotEmpty(message = "Product Name is required.")
    private String productName;

    @Length(max = 15, message = "Product Code must be less than 20 characters")
    @NotEmpty(message = "Product Code is required.")
    private String productCode;

    @Length(max = 2550, message = "Product Description must be less than 2550 characters")
    @NotEmpty(message = "Product Description is required.")
    private String productDescription;

    @NotNull(message = "Product Line Id is required.")
    private Integer productLineId;

    @Length(max = 10, message = "Product Scale must be less than 50 characters")
    @NotEmpty(message = "Product Scale is required.")
    private String productScale;

    @Length(max = 50, message = "Product Vendor must be less than 50 characters")
    @NotEmpty(message = "Product Vendor is required.")
    private String productVendor;

    @NotNull(message = "Quantity-in-Stock is required.")
    private Integer quantityInStock;

    @NotNull(message = "Buy Price is required.")
    private Double buyPrice;

    private Double msrp;
}
