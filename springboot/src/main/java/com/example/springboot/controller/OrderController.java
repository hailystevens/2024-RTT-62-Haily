package com.example.springboot.controller;

import com.example.springboot.database.dao.OrderDAO;
import com.example.springboot.database.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderController(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @GetMapping("/")
    public ModelAndView getOrders(@RequestParam(required = false) String name) {
        ModelAndView response = new ModelAndView("order");
        List<Order> orders = orderDAO.findByCustomerSearchTerm(name);

        response.addObject("orders", orders);
        response.addObject("name", name);
        return response;
    }

    @GetMapping("/{id}")
    public ModelAndView getOrderItem(@PathVariable int id) {
        ModelAndView response = new ModelAndView("orderItem");
        Order order = orderDAO.findOrderById(id);
        response.addObject("order", order);
        return response;
    }
}
