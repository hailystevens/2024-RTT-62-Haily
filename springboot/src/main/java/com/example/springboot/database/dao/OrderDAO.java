package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<Order, Integer> {

    // Method to find orders by customer id
    List<Order> findByCustomerId(Integer customerId);

    List<Order> findByStatus(String search);
}
