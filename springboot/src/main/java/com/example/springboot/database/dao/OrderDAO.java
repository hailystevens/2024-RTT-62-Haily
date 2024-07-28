
package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrderDAO extends JpaRepository<Order, Long> {
    Order findById(Integer id);

    @Query("select o from Order o where o.customerId = :customerId")
    List<Order> findByCustomerId(Integer customerId);

    @Query(value = "select o.id as order_id, o.order_date, od.quantity_ordered, p.product_name, p.id as product_id, " +
            "od.price_each, (od.quantity_ordered * od.price_each) as line_item_total " +
            "from orderdetails od, products p, orders o " +
            "where od.product_id = p.id and o.id = od.order_id " +
            "order by order_id;", nativeQuery = true)
    List<Map<String, Object>> getOrderDetails();


    @Query(value = "select o.id as order_id, o.order_date, od.quantity_ordered, p.product_name, p.id as product_id, " +
            "od.price_each, (od.quantity_ordered * od.price_each) as line_item_total " +
            "from orderdetails od, products p, orders o " +
            "where od.order_id = :orderId and o.id = :orderId and od.product_id = p.id " +
            "order by order_id;", nativeQuery = true)
    List<Map<String, Object>> getOrderDetailsByOrderId(Integer orderId);
}
