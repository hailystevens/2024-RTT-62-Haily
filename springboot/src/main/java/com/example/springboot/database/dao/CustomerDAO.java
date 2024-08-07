package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer, Long> {

    // Get ONE customer by id
    Customer findById(Integer id);

    // Get LIST of customers by name
    @Query("select c from Customer c where c.name like concat('%', :search, '%')")
    List<Customer> findByCustomerName(String search);
}