package com.example.springboot.database.dao;

import com.example.springboot.database.entity.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLineDAO extends JpaRepository<ProductLine, Integer> {
}
