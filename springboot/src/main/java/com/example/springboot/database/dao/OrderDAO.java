package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderDAO extends JpaRepository<Order, Integer> { // Requirement: Create one DAO/Repository for each table

    // Get ONE order by order id
    Optional<Order> findById(Integer id); // Requirement: Use a Spring Data query based on function name

    // Get LIST of orders by customer_id
    @Query("select o from Order o where o.customer.id = :id")
    // Requirement: Use an @Query (JPA non-native query)
    List<Order> findByCustomerId(Integer id);

    // Get LIST of orders by customer name, or like customer name
    @Query("select o from Order o join o.customer c where c.name like concat('%', :name, '%')")
    // Requirement: Use an @Query (JPA non-native query)
    List<Order> findByCustomerName(String name);

    // Get order details for a specific order
    @Query(value = "select o.id as order_id, o.order_date, od.quantity_ordered, od.price_each, " +
            "p.id as product_id, p.name as product_name, " +
            "(od.quantity_ordered * od.price_each) as line_item_total " +
            "from orders o " +
            "join orderdetails od on o.id = od.order_id " +
            "join products p on od.product_id = p.id " +
            "where o.id = :orderId", nativeQuery = true)
    // Requirement: Use a native query @Query(... native = true)
    List<Map<String, Object>> getOrderDetails(Integer orderId);
}
