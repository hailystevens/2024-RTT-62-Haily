package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.dao.OrderDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.Order;
import com.example.springboot.form.CreateCustomerFormBean;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private OrderDAO orderDAO;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView response = new ModelAndView("customer/list");
        List<Customer> customers = customerDAO.findAll();
        response.addObject("customersKey", customers);
        return response;
    }

    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("customer/detail");
        Optional<Customer> customerOpt = customerDAO.findById(id);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            response.addObject("customerKey", customer);

            List<Order> orders = customer.getOrders();
            log.debug("Orders found: " + orders.toString());
            response.addObject("ordersKey", orders);
        } else {
            log.debug("Customer not found with ID: " + id);
            response.setViewName("redirect:/customer/list");
        }
        return response;
    }

    @GetMapping("/search")
    public ModelAndView searchByCustomerName(@RequestParam String search) {
        ModelAndView response = new ModelAndView("customer/search");
        log.debug("The user searched for: " + search);
        response.addObject("searchKey", search);

        List<Customer> customers = customerDAO.findByNameContainingIgnoreCase(search);
        response.addObject("customersKey", customers);

        return response;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("customer/create");
        response.addObject("form", new CreateCustomerFormBean());
        return response;
    }

    @PostMapping("/createSubmit")
    public ModelAndView createSubmit(@Valid CreateCustomerFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error: " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }
            response.addObject("bindingResult", bindingResult);
            response.setViewName("customer/create");
            response.addObject("form", form);
            return response;
        } else {
            Customer customer = new Customer();
            if (form.getId() != null) {
                Optional<Customer> customerOpt = customerDAO.findById(form.getId());
                if (customerOpt.isPresent()) {
                    customer = customerOpt.get();
                }
            }

            customer.setName(form.getName());
            customer.setEmail(form.getEmail());
            customer.setPhone(form.getPhone());
            customer.setBillingAddress(form.getBillingAddress());
            customer.setShippingAddress(form.getShippingAddress());

            customer = customerDAO.save(customer);

            response.setViewName("redirect:/customer/" + customer.getId());
            return response;
        }
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required = false) Integer id) {
        ModelAndView response = new ModelAndView("customer/create");

        if (id != null) {
            Optional<Customer> customerOpt = customerDAO.findById(id);
            if (customerOpt.isPresent()) {
                Customer customer = customerOpt.get();
                CreateCustomerFormBean form = new CreateCustomerFormBean();
                form.setId(customer.getId());
                form.setName(customer.getName());
                form.setEmail(customer.getEmail());
                form.setPhone(customer.getPhone());
                form.setBillingAddress(customer.getBillingAddress());
                form.setShippingAddress(customer.getShippingAddress());
                response.addObject("form", form);
            }
        } else {
            response.addObject("message", "The customer was not found in the database.");
        }

        return response;
    }
}
