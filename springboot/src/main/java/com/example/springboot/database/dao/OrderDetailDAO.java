package com.example.springboot.database.dao;

import com.example.springboot.database.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> { // Requirement: Create one DAO/Repository for each table

    // Get ONE order detail ROW by order detail id
    OrderDetail findById(Integer id); // Requirement: Use a Spring Data query based on function name

    // Get LIST of order details by order_id
    @Query("select od, p.name from OrderDetail od inner join Product p " +
            " on od.id = p.id " +
            " where od.id= :id " +
            " order by od.orderLineNumber")
    // Requirement: Use an @Query (JPA non-native query)
    List<OrderDetail> findByOrderId(Integer id);
}
