package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductDAO extends JpaRepository<Product, Integer> {
    Optional<Product> findById(Integer id);

    List<Product> findByProductNameContainingIgnoreCase(String name);
}
