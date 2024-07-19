package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Integer> {
    @Query("select o from Order o where concat(o.id, ' ', o.orderDate, ' ', o.customer.id) like concat('%', :searchTerm, '%')")
    List<Order> findByCustomerSearchTerm(@Param("searchTerm") String searchTerm);

    Order findOrderById(int id);
}
