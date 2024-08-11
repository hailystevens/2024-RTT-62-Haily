package com.example.springboot.controller;

import com.example.springboot.database.dao.OrderDetailDAO;
import com.example.springboot.database.entity.OrderDetail;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // Requirement: Use @PathVariable
import org.springframework.web.bind.annotation.RequestParam; // Requirement: Use @RequestParam

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/order-detail") // Requirement: Proper folder structure using pub directory and WEB-INF/jsp
public class OrderDetailController {

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list") // Requirement: Have one GET controller method
    public ModelAndView list() {
        ModelAndView response = new ModelAndView("order-detail/list"); // Maps to order-detail/list.jsp
        List<OrderDetail> orderDetails = orderDetailDAO.findAll(); // Retrieve all order details
        response.addObject("orderDetailsKey", orderDetails); // Pass the order details list to the view
        return response;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}") // Requirement: Use @PathVariable
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("order-detail/detail"); // Maps to order-detail/detail.jsp
        log.debug("The user wants the orderDetail with order detail id:  " + id);
        OrderDetail orderDetail = orderDetailDAO.findById(id); // Retrieve order detail by ID
        response.addObject("orderDetailKey", orderDetail); // Pass the order detail to the view
        return response;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list-by-order") // Requirement: Use @RequestParam
    public ModelAndView listByOrderId(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("order-detail/list-by-order"); // Maps to order-detail/list-by-order.jsp
        log.debug("The user wants the order detail row(s) for order id:  " + id);
        response.addObject("orderIdKey", id);
        List<OrderDetail> orderDetails = orderDetailDAO.findByOrderId(id); // Retrieve order details by order ID
        response.addObject("orderDetailsKey", orderDetails); // Pass the order details list to the view
        return response;
    }
}
