package com.example.springboot.controller;

import com.example.springboot.database.dao.OrderDetailDAO;
import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Order;
import com.example.springboot.database.dao.OrderDAO;
import com.example.springboot.database.entity.OrderDetail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // Requirement: Use @PathVariable
import org.springframework.web.bind.annotation.RequestParam; // Requirement: Use @RequestParam
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @GetMapping("/list") // Requirement: Have one GET controller method
    public ModelAndView listAll() {
        ModelAndView response = new ModelAndView("order/list");
        List<Order> orders = orderDAO.findAll(); // Retrieve all orders from the database
        response.addObject("ordersKey", orders); // Pass the orders list to the view
        return response;
    }

    @GetMapping("/{id}") // Requirement: Use @PathVariable
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("order/detail");
        log.debug("The user wants the order with id: " + id);

        Optional<Order> orderOptional = orderDAO.findById(id); // Retrieve order by ID
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            response.addObject("orderKey", order); // Pass the order to the view

            List<OrderDetail> orderDetails = orderDetailDAO.findByOrderId(id); // Retrieve order details
            response.addObject("orderDetailsKey", orderDetails); // Pass the order details to the view

            // Add new fields
            response.addObject("paymentMethod", order.getPaymentMethod());
            response.addObject("shippingMethod", order.getShippingMethod());
            response.addObject("specialInstructions", order.getSpecialInstructions());
            response.addObject("totalAmount", order.getTotalAmount());
            response.addObject("trackingNumber", order.getTrackingNumber());
        } else {
            response.addObject("errorMessage", "Order not found"); // Handle case when order is not found
        }

        return response;
    }

    @GetMapping("/list-by-customer") // Requirement: Use @RequestParam
    public ModelAndView listByCustomerId(@RequestParam String id,
                                         @RequestParam(required = false) String name) {
        ModelAndView response = new ModelAndView("order/list-by-customer");
        log.debug("The user wants the order(s) for customer id: " + id + " and customer name: " + name);
        response.addObject("customerId", id);
        response.addObject("customerName", name);

        List<Order> orders = orderDAO.findByCustomerId(Integer.valueOf(id)); // Retrieve orders by customer ID
        response.addObject("ordersKey", orders); // Pass the orders list to the view

        return response;
    }

    @GetMapping("/search") // Requirement: Use @RequestParam
    public ModelAndView searchByCustomerName(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("order/search");
        log.debug("The user wants the order for this customer name: " + search);

        List<Order> orders = orderDAO.findByCustomerName(search); // Search orders by customer name
        response.addObject("ordersKey", orders); // Pass the search results to the view
        response.addObject("searchKey", search);

        return response;
    }

    @GetMapping("/orderdetail") // Requirement: Use @RequestParam
    public ModelAndView orderDetail(@RequestParam Integer orderId) {
        ModelAndView response = new ModelAndView("order/orderdetail");

        List<Map<String, Object>> orderDetails = orderDAO.getOrderDetails(orderId); // Retrieve order details using a custom query
        response.addObject("orderDetailsKey", orderDetails); // Pass the order details to the view
        response.addObject("orderIdKey", orderId); // Pass the order ID to the view

        return response;
    }
}