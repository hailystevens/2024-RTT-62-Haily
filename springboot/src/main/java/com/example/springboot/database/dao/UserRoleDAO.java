package com.example.springboot.database.dao;

import com.example.springboot.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> { // Requirement: Create one DAO/Repository for each table

    // Requirement: Use a Spring Data query based on function name
    // This method generates a query to find user roles by the user ID.
    List<UserRole> findByUserId(Integer userId);
}
