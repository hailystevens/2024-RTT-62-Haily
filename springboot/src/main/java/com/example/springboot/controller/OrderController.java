package com.example.springboot.controller;

import com.example.springboot.database.dao.OrderDAO;
import com.example.springboot.database.entity.Order;
import com.example.springboot.form.CreateOrderFormBean;
import com.example.springboot.service.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderService orderService;

    // List all orders
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView response = new ModelAndView("order/list");
        List<Order> orders = orderDAO.findAll();
        response.addObject("ordersKey", orders);
        return response;
    }

    // View order details
    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("order/detail");
        Optional<Order> orderOpt = orderDAO.findById(id);
        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            response.addObject("orderKey", order);
        } else {
            response.addObject("messageKey", "Order not found");
        }
        return response;
    }

    // Search for orders by customer ID
    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false) Integer customerId) {
        ModelAndView response = new ModelAndView("order/search");
        response.addObject("searchKey", customerId);
        List<Order> orders = orderDAO.findByCustomerId(customerId);
        response.addObject("ordersKey", orders);
        return response;
    }

    // Show create order form
    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("order/create");
    }

    // Handle order creation
    @PostMapping("/createSubmit")
    public ModelAndView createSubmit(@Valid CreateOrderFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        if (bindingResult.hasErrors()) {
            response.addObject("bindingResult", bindingResult);
            response.setViewName("order/create");
            response.addObject("form", form);
            return response;
        } else {
            Order order = orderService.createOrder(form);
            response.setViewName("redirect:/order/" + order.getId());
            return response;
        }
    }

    // Show edit order form
    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required = false) Integer id) {
        ModelAndView response = new ModelAndView("order/create");
        if (id != null) {
            Optional<Order> orderOpt = orderDAO.findById(id);
            if (orderOpt.isPresent()) {
                Order order = orderOpt.get();
                CreateOrderFormBean form = new CreateOrderFormBean();
                form.setId(order.getId());
                form.setCustomerId(order.getCustomer().getId());
                form.setOrderDate(order.getOrderDate());
                form.setRequiredDate(order.getRequiredDate());
                form.setShippedDate(order.getShippedDate());
                form.setStatus(order.getStatus());
                form.setComments(order.getComments());
                response.addObject("form", form);
            } else {
                response.addObject("messageKey", "The order was not found in the database.");
            }
        }
        return response;
    }
}
