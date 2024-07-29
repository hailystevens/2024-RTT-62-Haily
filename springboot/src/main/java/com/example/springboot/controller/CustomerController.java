package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.form.CreateCustomerFormBean;
import com.example.springboot.service.CustomerService;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private CustomerService customerService;

    // List all customers
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView response = new ModelAndView("customer/list");
        List<Customer> customers = customerDAO.findAll();
        response.addObject("customersKey", customers);
        return response;
    }

    // View customer details
    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("customer/detail");
        Optional<Customer> customerOpt = customerDAO.findById(id);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            response.addObject("customerKey", customer);
        } else {
            response.addObject("messageKey", "Customer not found");
        }
        return response;
    }

    // Search for customers
    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("customer/search");
        response.addObject("searchKey", search);
        List<Customer> customers = customerDAO.findByCustomerNameContaining(search);
        response.addObject("customersKey", customers);
        return response;
    }

    // Show create customer form
    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("customer/create");
    }

    // Handle customer creation
    @PostMapping("/createSubmit")
    public ModelAndView createSubmit(@Valid CreateCustomerFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        if (bindingResult.hasErrors()) {
            response.addObject("bindingResult", bindingResult);
            response.setViewName("customer/create");
            response.addObject("form", form);
            return response;
        } else {
            Customer customer = customerService.createCustomer(form);
            response.setViewName("redirect:/customer/" + customer.getId());
            return response;
        }
    }

    // Show edit customer form
    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required = false) Integer id) {
        ModelAndView response = new ModelAndView("customer/create");
        if (id != null) {
            Optional<Customer> customerOpt = customerDAO.findById(id);
            if (customerOpt.isPresent()) {
                Customer customer = customerOpt.get();
                CreateCustomerFormBean form = new CreateCustomerFormBean();
                form.setId(customer.getId());
                form.setCustomerName(customer.getCustomerName());
                form.setContactLastName(customer.getContactLastName());
                form.setContactFirstName(customer.getContactFirstName());
                form.setPhone(customer.getPhone());
                form.setAddressLine1(customer.getAddressLine1());
                form.setAddressLine2(customer.getAddressLine2());
                form.setCity(customer.getCity());
                form.setState(customer.getState());
                form.setPostalCode(customer.getPostalCode());
                form.setCountry(customer.getCountry());
                form.setCreditLimit(customer.getCreditLimit());
                response.addObject("form", form);
            } else {
                response.addObject("messageKey", "The customer was not found in the database.");
            }
        }
        return response;
    }
}
