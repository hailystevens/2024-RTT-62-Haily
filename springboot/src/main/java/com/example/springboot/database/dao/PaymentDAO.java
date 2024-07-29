package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentDAO extends JpaRepository<Payment, Integer> {

    // Method to find payments by customer id
    List<Payment> findByCustomerId(Integer customerId);
}
