package com.example.springboot.controller;

import com.example.springboot.database.dao.OrderDAO;
import com.example.springboot.database.dao.OrderDetailDAO;
import com.example.springboot.database.entity.Order;
import com.example.springboot.database.entity.OrderDetail;
import com.example.springboot.form.OrderDetailsBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @GetMapping("/list")
    public ModelAndView orderList(@RequestParam Integer customerId) {
        ModelAndView response = new ModelAndView("orderList");

        List<Order> orders = orderDAO.findByCustomerId(customerId);
        response.addObject("orders", orders);

        return response;
    }

    @GetMapping("/detail")
    public ModelAndView orderDetail(@RequestParam Integer orderId) {
        ModelAndView response = new ModelAndView("orderDetails");

        Optional<Order> orderOpt = orderDAO.findById(orderId);
        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            response.addObject("order", order);

            List<OrderDetail> orderDetails = orderDetailDAO.findByOrderId(orderId);
            response.addObject("orderDetails", orderDetails);

            double orderTotal = orderDetails.stream()
                    .mapToDouble(od -> od.getQuantityOrdered() * od.getPriceEach())
                    .sum();
            response.addObject("orderTotal", orderTotal);
        } else {
            // Handle case where order is not found
            response.setViewName("error/404");
        }

        return response;
    }

    @GetMapping("/allOrderDetails")
    public ModelAndView allOrderDetails() {
        ModelAndView response = new ModelAndView("allOrderDetails");

        List<OrderDetail> orderDetails = orderDetailDAO.findAll();
        response.addObject("orderDetails", orderDetails);

        return response;
    }
}
