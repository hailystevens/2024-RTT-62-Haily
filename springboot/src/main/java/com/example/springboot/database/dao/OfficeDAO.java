package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfficeDAO extends JpaRepository<Office, Integer> {
    Optional<Office> findById(Integer id);
}
