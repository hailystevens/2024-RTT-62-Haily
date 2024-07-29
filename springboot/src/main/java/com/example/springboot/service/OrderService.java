package com.example.springboot.service;

import com.example.springboot.database.dao.OrderDAO;
import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.entity.Order;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.form.CreateOrderFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private CustomerDAO customerDAO;

    public Order createOrder(CreateOrderFormBean form) {
        log.debug(form.toString());

        Order order = orderDAO.findById(form.getId()).orElse(new Order());

        order.setOrderDate(form.getOrderDate());
        order.setRequiredDate(form.getRequiredDate());
        order.setShippedDate(form.getShippedDate());
        order.setStatus(form.getStatus());
        order.setComments(form.getComments());

        Optional<Customer> customerOpt = customerDAO.findById(form.getCustomerId());
        if (customerOpt.isPresent()) {
            order.setCustomer(customerOpt.get());
        } else {
            log.error("Customer ID " + form.getCustomerId() + " not found");
        }

        order = orderDAO.save(order);

        return order;
    }
}
