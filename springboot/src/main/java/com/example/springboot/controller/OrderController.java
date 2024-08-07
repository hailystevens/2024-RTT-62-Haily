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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/list")
    public ModelAndView listAll() {
        ModelAndView response = new ModelAndView("order/list");
        List<Order> orders = orderDAO.findAll();
        response.addObject("ordersKey", orders);
        return response;
    }

    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("order/detail");
        log.debug("The user wants the order with id: " + id);

        Optional<Order> orderOptional = orderDAO.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            response.addObject("orderKey", order);

            List<OrderDetail> orderDetails = orderDetailDAO.findByOrderId(id);
            response.addObject("orderDetailsKey", orderDetails);
        } else {
            response.addObject("errorMessage", "Order not found");
        }

        return response;
    }

    @GetMapping("/list-by-customer")
    public ModelAndView listByCustomerId(@RequestParam String id,
                                         @RequestParam(required = false) String name) {
        ModelAndView response = new ModelAndView("order/list-by-customer");
        log.debug("The user wants the order(s) for customer id: " + id + " and customer name: " + name);
        response.addObject("customerId", id);
        response.addObject("customerName", name);

        List<Order> orders = orderDAO.findByCustomerId(Integer.valueOf(id));
        response.addObject("ordersKey", orders);

        return response;
    }

    @GetMapping("/search")
    public ModelAndView searchByCustomerName(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("order/search");
        log.debug("The user wants the order for this customer name: " + search);

        List<Order> orders = orderDAO.findByCustomerName(search);
        response.addObject("ordersKey", orders);
        response.addObject("searchKey", search);

        return response;
    }

    @GetMapping("/orderdetail")
    public ModelAndView orderDetail(@RequestParam Integer orderId) {
        ModelAndView response = new ModelAndView("order/orderdetail");

        List<Map<String, Object>> orderDetails = orderDAO.getOrderDetails(orderId);
        response.addObject("orderDetailsKey", orderDetails);
        response.addObject("orderIdKey", orderId);

        return response;
    }
}
