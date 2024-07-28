package com.example.springboot.database.dao;

import com.example.springboot.database.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
    OrderDetail findById(Integer id);

    @Query("select od from OrderDetail od where od.order.id = :orderId")
    List<OrderDetail> findByOrderId(Integer orderId);
}
