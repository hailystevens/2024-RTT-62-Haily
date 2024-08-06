package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.Employee;
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

@Slf4j
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private EmployeeDAO employeeDAO;

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
        Customer customer = customerDAO.findById(id);
        response.addObject("customerKey", customer);

        List<Order> orders = customer.getOrders();
        response.addObject("ordersKey", orders);

        return response;
    }

    @GetMapping("/search")
    public ModelAndView searchByCustomerName(@RequestParam String search) {
        ModelAndView response = new ModelAndView("customer/search");
        log.debug("The user searched for: " + search);
        response.addObject("searchKey", search);

        List<Customer> customers = customerDAO.findByCustomerName(search);
        response.addObject("customersKey", customers);

        return response;
    }

    @GetMapping("/list-by-employee")
    public ModelAndView listByEmployeeId(@RequestParam String id,
                                         @RequestParam(required = false) String name) {
        ModelAndView response = new ModelAndView("customer/list-by-employee");
        log.debug("The user wants the customer(s) for employee id: " + id + " and employee name: " + name);
        response.addObject("employeeId", id);
        response.addObject("employeeName", name);

        List<Customer> customers = customerDAO.findByEmployeeId(Integer.valueOf(id));
        response.addObject("customersKey", customers);

        return response;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("customer/create");
        List<Employee> employees = employeeDAO.findAll();
        response.addObject("employeesKey", employees);
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
            List<Employee> reportsToEmployees = employeeDAO.findAll();
            response.addObject("employeesKey", reportsToEmployees);
            response.setViewName("customer/create");
            response.addObject("form", form);
            return response;
        } else {
            Customer customer = customerDAO.findById(form.getId());
            if (customer == null) {
                customer = new Customer();
            }

            customer.setCustomerName(form.getCustomerName());
            customer.setContactFirstName(form.getContactFirstName());
            customer.setContactLastName(form.getContactLastName());
            customer.setPhone(form.getPhone());
            customer.setAddressLine1(form.getAddressLine1());
            customer.setAddressLine2(form.getAddressLine2());
            customer.setCity(form.getCity());
            customer.setState(form.getState());
            customer.setPostalCode(form.getPostalCode());
            customer.setCountry(form.getCountry());
            customer.setCreditLimit(form.getCreditLimit());
            customer.setSalesRepEmployeeId(form.getSalesRepEmployeeId());

            Employee employee = employeeDAO.findById(form.getSalesRepEmployeeId());
            customer.setEmployee(employee);

            customer = customerDAO.save(customer);

            response.setViewName("redirect:/customer/" + customer.getId());
            return response;
        }
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required = false) Integer id) {
        ModelAndView response = new ModelAndView("customer/create");

        List<Employee> employees = employeeDAO.findAll();
        response.addObject("employeesKey", employees);

        if (id != null) {
            Customer customer = customerDAO.findById(id);
            if (customer != null) {
                CreateCustomerFormBean form = new CreateCustomerFormBean();
                form.setId(customer.getId());
                form.setCustomerName(customer.getCustomerName());
                form.setContactFirstName(customer.getContactFirstName());
                form.setContactLastName(customer.getContactLastName());
                form.setPhone(customer.getPhone());
                form.setAddressLine1(customer.getAddressLine1());
                form.setAddressLine2(customer.getAddressLine2());
                form.setCity(customer.getCity());
                form.setState(customer.getState());
                form.setPostalCode(customer.getPostalCode());
                form.setCountry(customer.getCountry());
                form.setCreditLimit(customer.getCreditLimit());
                form.setSalesRepEmployeeId(customer.getSalesRepEmployeeId());
                response.addObject("form", form);
            }
        } else {
            response.addObject("message", "The customer was not found in the database.");
        }

        return response;
    }
}
