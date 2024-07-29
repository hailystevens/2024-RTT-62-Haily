package com.example.springboot.service;

import com.example.springboot.database.dao.OrderDetailDAO;
import com.example.springboot.database.entity.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        return orderDetailDAO.save(orderDetail);
    }

    public OrderDetail getOrderDetailById(Integer id) {
        return orderDetailDAO.findById(id).orElse(null);
    }

    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailDAO.findAll();
    }

    public void deleteOrderDetailById(Integer id) {
        orderDetailDAO.deleteById(id);
    }
}
