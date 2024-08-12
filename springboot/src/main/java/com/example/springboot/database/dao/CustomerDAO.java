package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer, Integer> { // Requirement: Create one DAO/Repository for each table

    @Query("SELECT c FROM Customer c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
        // Requirement: Use an @Query (JPA non-native query)
    List<Customer> findByNameContainingIgnoreCase(String name); // Requirement: Use a Spring Data query based on function name

    Customer findByEmail(String email);

}
