package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> { // Requirement: Create one DAO/Repository for each table

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(p.category) LIKE LOWER(CONCAT('%', :search, '%'))")
        // Requirement: Use an @Query (JPA non-native query)
    List<Product> findByNameOrCategory(@Param("search") String search); // Requirement: Use a Spring Data query based on function name
}