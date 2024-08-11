package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.dao.OrderDetailDAO;
import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.*;
import com.example.springboot.database.dao.OrderDAO;
import com.example.springboot.security.AuthenticatedUserUtilities;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // Requirement: Use @PathVariable
import org.springframework.web.bind.annotation.RequestParam; // Requirement: Use @RequestParam
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
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

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list") // Requirement: Have one GET controller method
    public ModelAndView listAll() {
        ModelAndView response = new ModelAndView("order/list");
        List<Order> orders = orderDAO.findAll(); // Retrieve all orders from the database
        response.addObject("ordersKey", orders); // Pass the orders list to the view
        return response;
    }

    @PreAuthorize("hasRole('ADMIN')")
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

    @PreAuthorize("hasRole('ADMIN')")
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

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/search") // Requirement: Use @RequestParam
    public ModelAndView searchByCustomerName(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("order/search");
        log.debug("The user wants the order for this customer name: " + search);

        List<Order> orders = orderDAO.findByCustomerName(search); // Search orders by customer name
        response.addObject("ordersKey", orders); // Pass the search results to the view
        response.addObject("searchKey", search);

        return response;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/orderdetail") // Requirement: Use @RequestParam
    public ModelAndView orderDetail(@RequestParam Integer orderId) {
        ModelAndView response = new ModelAndView("order/orderdetail");

        List<Map<String, Object>> orderDetails = orderDAO.getOrderDetails(orderId); // Retrieve order details using a custom query
        response.addObject("orderDetailsKey", orderDetails); // Pass the order details to the view
        response.addObject("orderIdKey", orderId); // Pass the order ID to the view

        return response;
    }

    @GetMapping("/addToCart")
    public ModelAndView addToCart(@RequestParam Integer productId) {
        ModelAndView response = new ModelAndView();

        Product product = productDAO.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product with id " + productId + " not found"));

        Customer customer = authenticatedUserUtilities.getCurrentCustomer();

        Order order = orderDAO.findOrderInCartStatus(customer.getId())
                .orElseGet(() -> {
                    Order newOrder = new Order();
                    newOrder.setCustomer(customer);
                    newOrder.setOrderDate(new Date());
                    newOrder.setStatus("CART");
                    orderDAO.save(newOrder);
                    return newOrder;
                });

        OrderDetail orderDetail = orderDetailDAO.isProductInCart(order.getId(), productId)
                .orElseGet(() -> {
                    OrderDetail newOrderDetail = new OrderDetail();
                    newOrderDetail.setOrder(order);
                    newOrderDetail.setProduct(product);
                    newOrderDetail.setQuantityOrdered(1);
                    orderDetailDAO.save(newOrderDetail);
                    return newOrderDetail;
                });

        orderDetail.setQuantityOrdered(orderDetail.getQuantityOrdered() + 1);
        orderDetailDAO.save(orderDetail);

        response.setViewName("redirect:/order/orderdetail");
        return response;
    }

    @GetMapping("/checkout")
    public ModelAndView checkout() {
        ModelAndView response = new ModelAndView();

        Customer customer = authenticatedUserUtilities.getCurrentCustomer();

        if (customer == null) {
            throw new RuntimeException("No customer found for the current user");
        }

        Order order = orderDAO.findOrderInCartStatus(customer.getId())
                .orElseThrow(() -> new RuntimeException("There is no order with items in the cart to checkout"));

        order.setStatus("COMPLETE");
        orderDAO.save(order);

        response.setViewName("redirect:/order/orderdetail");
        return response;
    }
}
