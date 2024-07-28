package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.form.CreateCustomerFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping("/create")
    public ModelAndView createCustomer(@RequestParam(required = false) Integer customerId) {
        ModelAndView response = new ModelAndView("createCustomer");

        CreateCustomerFormBean form = new CreateCustomerFormBean();
        if (customerId != null) {
            Optional<Customer> customerOpt = customerDAO.findById(customerId);
            if (customerOpt.isPresent()) {
                Customer customer = customerOpt.get();
                form.setId(customer.getId());
                form.setCustomerName(customer.getCustomerName());
                form.setContactFirstname(customer.getContactFirstname());
                form.setContactLastname(customer.getContactLastname());
                form.setPhone(customer.getPhone());
                form.setAddressLine1(customer.getAddressLine1());
                form.setAddressLine2(customer.getAddressLine2());
                form.setCity(customer.getCity());
                form.setState(customer.getState());
                form.setPostalCode(customer.getPostalCode());
                form.setCountry(customer.getCountry());
                form.setCreditLimit(customer.getCreditLimit());
                form.setSalesRepEmployeeId(customer.getEmployee().getId());
            }
        }

        List<Employee> employees = employeeDAO.findAll();
        response.addObject("salesRepEmployees", employees);
        response.addObject("form", form);

        return response;
    }

    @PostMapping("/createSubmit")
    public ModelAndView createCustomerSubmit(CreateCustomerFormBean form) {
        log.info("form is: " + form.toString());

        Customer customer;
        Integer customerId = form.getId();
        log.info("submit customerId: " + customerId);

        boolean isNewCustomer = customerId == null;

        if (isNewCustomer) {
            customer = new Customer();
        } else {
            customer = customerDAO.findById(customerId).orElse(new Customer());
        }

        customer.setCustomerName(form.getCustomerName());
        customer.setContactFirstname(form.getContactFirstname());
        customer.setContactLastname(form.getContactLastname());
        customer.setPhone(form.getPhone());
        customer.setAddressLine1(form.getAddressLine1());
        customer.setAddressLine2(form.getAddressLine2());
        customer.setCity(form.getCity());
        customer.setState(form.getState());
        customer.setPostalCode(form.getPostalCode());
        customer.setCountry(form.getCountry());
        customer.setCreditLimit(form.getCreditLimit());

        Employee employee = employeeDAO.findById(form.getSalesRepEmployeeId()).orElse(null);
        customer.setEmployee(employee);

        customer = customerDAO.save(customer);

        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/customer/detail?customerId=" + customer.getId());

        return response;
    }

    @GetMapping("/detail")
    public ModelAndView customerDetails(@RequestParam Integer customerId) {
        ModelAndView response = new ModelAndView("customerDetails");

        Optional<Customer> customerOpt = customerDAO.findById(customerId);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            response.addObject("customer", customer);
        } else {
            // Handle the case where the customer is not found
            response.setViewName("error/404");
        }

        return response;
    }
}
