package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    Optional<Customer> findById(Integer id);

    @Query("select c from Customer c where c.salesRepEmployeeId = :employeeId")
    List<Customer> findByEmployeeId(Integer employeeId);
}
