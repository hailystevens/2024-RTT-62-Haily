package com.example.springboot.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateProductLineFormBean {

    private Integer id;

    @NotEmpty(message = "Product Line is required.")
    private String productLine;

    private String description;
}
