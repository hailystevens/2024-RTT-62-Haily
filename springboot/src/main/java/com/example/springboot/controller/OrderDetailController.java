package com.example.springboot.controller;

import com.example.springboot.database.dao.OrderDetailDAO;
import com.example.springboot.database.entity.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/order-detail")
public class OrderDetailController {

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    // List all order details
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView response = new ModelAndView("order-detail/list");
        List<OrderDetail> orderDetails = orderDetailDAO.findAll();
        response.addObject("orderDetailsKey", orderDetails);
        return response;
    }

    // View order detail by ID
    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("order-detail/detail");
        log.debug("The user wants the orderDetail with order detail id: " + id);

        OrderDetail orderDetail = orderDetailDAO.findById(id).orElse(null);
        response.addObject("orderDetailKey", orderDetail);
        return response;
    }

    // List order details by order ID
    @GetMapping("/list-by-order")
    public ModelAndView listByOrderId(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("order-detail/list-by-order");
        log.debug("The user wants the order detail row(s) for order id: " + id);
        response.addObject("orderIdKey", id);

        List<OrderDetail> orderDetails = orderDetailDAO.findByOrderId(id);
        response.addObject("orderDetailsKey", orderDetails);
        return response;
    }
}
