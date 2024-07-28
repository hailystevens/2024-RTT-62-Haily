package com.example.springboot.service;

import com.example.springboot.database.dao.OrderDAO;
import com.example.springboot.database.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    public Optional<Order> getOrderById(Integer id) {
        return orderDAO.findById(id);
    }

    public List<Order> getOrdersByCustomerId(Integer customerId) {
        return orderDAO.findByCustomerId(customerId);
    }

    public List<Map<String, Object>> getAllOrderDetails() {
        return orderDAO.getOrderDetails();
    }

    public List<Map<String, Object>> getOrderDetailsByOrderId(Integer orderId) {
        return orderDAO.getOrderDetailsByOrderId(orderId);
    }
}
