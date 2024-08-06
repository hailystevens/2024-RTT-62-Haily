package com.example.springboot.controller;

import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OfficeDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Office;
import com.example.springboot.form.CreateEmployeeFormBean;
import com.example.springboot.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private OfficeDAO officeDAO;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public ModelAndView findAll() {
        ModelAndView response = new ModelAndView("employee/list");
        List<Employee> employees = employeeDAO.findAll();
        response.addObject("employeesKey", employees);
        return response;
    }

    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("employee/detail");
        Employee employee = employeeDAO.findById(id);
        if (employee == null) {
            response.addObject("errorMessage", "Employee not found");
            response.setViewName("error");
            return response;
        }
        response.addObject("employeeKey", employee);
        List<Customer> customers = employee.getCustomers();
        response.addObject("customersKey", customers);
        return response;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("employee/search");
        log.debug("The user searched for the term: " + search);
        response.addObject("searchKey", search);
        List<Employee> employees = employeeDAO.findByFirstOrLastNameOrJobTitle(search);
        response.addObject("employeesKey", employees);
        return response;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("employee/create");
        loadDropdowns(response);
        return response;
    }

    @PostMapping("/createSubmit")
    public ModelAndView createSubmit(@Valid CreateEmployeeFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }
            response.addObject("bindingResult", bindingResult);
            loadDropdowns(response);
            response.setViewName("employee/create");
            response.addObject("form", form);
            return response;
        } else {
            Employee employee = employeeService.createEmployee(form);
            response.setViewName("redirect:/employee/" + employee.getId());
            return response;
        }
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required = false) Integer id) {
        ModelAndView response = new ModelAndView("employee/create");
        loadDropdowns(response);
        if (id != null) {
            Employee employee = employeeDAO.findById(id);
            if (employee != null) {
                CreateEmployeeFormBean form = new CreateEmployeeFormBean();
                form.setId(employee.getId());
                form.setEmail(employee.getEmail());
                form.setFirstName(employee.getFirstName());
                form.setLastName(employee.getLastName());
                form.setProfileImageUrl(employee.getProfileImageUrl());
                form.setReportsTo(employee.getReportsTo());
                form.setOfficeId(employee.getOffice().getId());
                response.addObject("form", form);
            }
        } else {
            response.addObject("message", "The employee was not found in the database.");
        }
        return response;
    }

    private void loadDropdowns(ModelAndView response) {
        List<Employee> reportsToEmployees = employeeDAO.findAll();
        response.addObject("employeesKey", reportsToEmployees);
        List<Office> offices = officeDAO.findAll();
        response.addObject("officesKey", offices);
    }
}
