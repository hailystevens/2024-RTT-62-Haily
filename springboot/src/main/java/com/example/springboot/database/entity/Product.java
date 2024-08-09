package com.example.springboot.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
// Requirement: Proper primary keys / foreign keys, column names lowercase, pk called id, fk tablename_id
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Requirement: Proper primary keys
    @Column(name = "id")
    private Integer id;

    @Column(name = "name") // Requirement: Column names lowercase
    private String name;

    @Column(name = "brand") // Requirement: Column names lowercase
    private String brand;

    @Column(name = "category") // Requirement: Column names lowercase
    private String category;

    @Column(name = "price", columnDefinition = "DECIMAL") // Requirement: Column names lowercase
    private Double price;

    @Column(name = "description", columnDefinition = "TEXT") // Requirement: Column names lowercase
    private String description;

    @Column(name = "image_file_name") // Requirement: Column names lowercase
    private String imageFileName;

    @Temporal(TemporalType.TIMESTAMP) // Requirement: Column names lowercase
    @Column(name = "created_at")
    private Date createdAt;

    @Transient // `@Transient` indicates this field is not persisted in the database
    private MultipartFile imageFile;
}