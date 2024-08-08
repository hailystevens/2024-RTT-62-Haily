package com.example.springboot.form;

import lombok.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class CreateProductFormBean {
    private Integer id;

    @Length(max = 255, message = "Product Name must be less than 255 characters")
    @NotEmpty(message = "Product Name is required.")
    private String name;

    @Length(max = 255, message = "Brand must be less than 255 characters")
    @NotEmpty(message = "Brand is required.")
    private String brand;

    @Length(max = 255, message = "Category must be less than 255 characters")
    @NotEmpty(message = "Category is required.")
    private String category;

    @Length(max = 2550, message = "Product Description must be less than 2550 characters")
    @NotEmpty(message = "Product Description is required.")
    private String description;

    @NotNull(message = "Price is required.")
    private Double price;

    private MultipartFile imageFile;
}
