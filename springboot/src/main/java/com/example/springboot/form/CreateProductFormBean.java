package com.example.springboot.form;

import lombok.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class CreateProductFormBean {

    private Integer id; // Field for product ID

    @Length(max = 255, message = "Product Name must be less than 255 characters")
    // Requirement: Form bean with 2 different validation annotations
    @NotEmpty(message = "Product Name is required.") // Requirement: Form bean with 2 different validation annotations
    private String name;

    @Length(max = 255, message = "Brand must be less than 255 characters")
    // Requirement: Form bean with 2 different validation annotations
    @NotEmpty(message = "Brand is required.") // Requirement: Form bean with 2 different validation annotations
    private String brand;

    @Length(max = 255, message = "Category must be less than 255 characters")
    // Requirement: Form bean with 2 different validation annotations
    @NotEmpty(message = "Category is required.") // Requirement: Form bean with 2 different validation annotations
    private String category;

    @Length(max = 2550, message = "Product Description must be less than 2550 characters")
    // Requirement: Form bean with 2 different validation annotations
    @NotEmpty(message = "Product Description is required.")
    // Requirement: Form bean with 2 different validation annotations
    private String description;

    @NotNull(message = "Price is required.") // Requirement: Form bean with 2 different validation annotations
    private Double price;

    private MultipartFile imageFile; // Field for the image file, used for file upload

    private boolean ripe;
}
