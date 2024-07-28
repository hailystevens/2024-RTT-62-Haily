
package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OrderDAO;
import com.example.springboot.database.entity.Customer;

import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Office;
import com.example.springboot.database.entity.Order;
import com.example.springboot.form.CreateCustomerFormBean;
import com.example.springboot.form.CreateEmployeeFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private OrderDAO orderDAO;

    @GetMapping("/detail")
    public ModelAndView customerDetails(@RequestParam(required = false) String customerId) {

        ModelAndView response = new ModelAndView("customerDetails");

        Customer customer = customerDAO.findById(Integer.valueOf(customerId));
        response.addObject("customer", customer);

        List<Order> orders = orderDAO.findByCustomerId(Integer.valueOf(customerId));
        response.addObject("orders", orders);

        log.info("customerId is: " + customerId);
        log.info("customer is: " + customer);


        return response;
    }

    @GetMapping("/create")
    public ModelAndView customerCreate() {

        ModelAndView response = new ModelAndView("createCustomer");

        List<Employee> employees = employeeDAO.findAll();
        response.addObject("salesRepEmployees", employees);

        return response;
    }

    @GetMapping("/createSubmit")
    public ModelAndView createEmployeeSubmit(CreateCustomerFormBean form) {
        log.info("form is: " + form.toString());

        Customer customer;
        Integer customerId = form.getId();
        log.info("submit customerId: " + customerId);

        boolean isNewEmployee = customerId == null;

        if (isNewEmployee) {
            customer = new Customer();
        } else {
            customer = customerDAO.findById(customerId);

        }

        customer.setCustomerName(form.getCustomerName());
        customer.setContactFirstname(form.getContactFirstname());
        customer.setContactLastname(form.getContactLastname());
        customer.setPhone(form.getPhone());
        customer.setAddressLine1(form.getAddressLine1());
        customer.setAddressLine2(form.getAddressLine2());
        customer.setCity(form.getCity());
        customer.setState(form.getState());
        customer.setCountry(form.getCountry());
        customer.setCreditLimit(form.getCreditLimit());
        customer.setPostalCode(form.getPostalCode());

        Employee employee = employeeDAO.findById(form.getSalesRepEmployeeId());
        customer.setEmployee(employee);

        customer = customerDAO.save(customer);

        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/customer/detail?customerId=" + customer.getId());

        return response;
    }

    @GetMapping("/edit")
    public ModelAndView editCustomer(@RequestParam(required = false) Integer customerId) {

        ModelAndView response = new ModelAndView("createCustomer");


        log.info("edit customerId: " + customerId);

        if (customerId == null) {
            return response;
        }

        Customer customer = customerDAO.findById(customerId);

        if (customer == null) {
            return response;
        }

        log.info("edit customer: " + customer);

        CreateCustomerFormBean form = new CreateCustomerFormBean();

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
        form.setSalesRepEmployeeId(customer.getSalesRepEmployeeId());

        log.info("edit form: " + form);

        List<Employee> employees = employeeDAO.findAll();
        response.addObject("salesRepEmployees", employees);


        response.addObject("form", form);

        return response;
    }
}
