package com.example.springboot.database.dao;

import com.example.springboot.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> { // Requirement: Create one DAO/Repository for each table

    // Requirement: Use a Spring Data query based on function name
    // This method generates a query to find a user by email, ignoring case sensitivity.
    User findByEmailIgnoreCase(String email);
}
