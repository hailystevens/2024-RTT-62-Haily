package com.example.springboot.controller;

import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.form.CreateEmployeeFormBean;
import com.example.springboot.service.EmployeeService;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeService employeeService;

    // List all employees and provide search functionality
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("employee/list");
        List<Employee> employees;
        if (search != null && !search.isEmpty()) {
            employees = employeeDAO.findByFirstOrLastNameOrJobTitle(search);
        } else {
            employees = employeeDAO.findAll();
        }
        response.addObject("employeesKey", employees);
        return response;
    }

    // View employee details
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("employee/detail");
        Optional<Employee> employeeOpt = employeeDAO.findById(id);
        if (employeeOpt.isPresent()) {
            response.addObject("employeeKey", employeeOpt.get());
        } else {
            response.addObject("messageKey", "Employee not found");
        }
        return response;
    }

    // Search for employees
    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("employee/search");
        response.addObject("searchKey", search);
        List<Employee> employees = employeeDAO.findByFirstOrLastNameOrJobTitle(search);
        response.addObject("employeesKey", employees);
        return response;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("employee/create");
        List<Employee> employees = employeeDAO.findAll();
        response.addObject("employeesKey", employees);
        response.addObject("form", new CreateEmployeeFormBean());
        return response;
    }
    // Handle employee creation
    @PostMapping("/createSubmit")
    public ModelAndView createSubmit(@Valid CreateEmployeeFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        if (bindingResult.hasErrors()) {
            response.addObject("bindingResult", bindingResult);
            response.setViewName("employee/create");
            response.addObject("form", form);
            return response;
        } else {
            Employee employee = new Employee();
            if (form.getId() != null) {
                employee = employeeDAO.findById(form.getId()).orElse(new Employee());
            }
            employee.setEmail(form.getEmail());
            employee.setFirstName(form.getFirstName());
            employee.setLastName(form.getLastName());
            employee.setExtension(form.getExtension());
            employee.setJobTitle(form.getJobTitle());
            employee.setVacationHours(form.getVacationHours());
            employee.setProfileImageUrl(form.getProfileImageUrl());
            employee.setOfficeId(form.getOfficeId());
            employee.setReportsTo(form.getReportsTo());

            employeeDAO.save(employee);

            response.setViewName("redirect:/employee/list?success=true");
            return response;
        }
    }


    // Show edit employee form
    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required = false) Integer id) {
        ModelAndView response = new ModelAndView("employee/create");
        if (id != null) {
            Optional<Employee> employeeOpt = employeeDAO.findById(id);
            if (employeeOpt.isPresent()) {
                Employee employee = employeeOpt.get();
                CreateEmployeeFormBean form = new CreateEmployeeFormBean();
                form.setId(employee.getId());
                form.setEmail(employee.getEmail());
                form.setFirstName(employee.getFirstName());
                form.setLastName(employee.getLastName());
                form.setExtension(employee.getExtension());
                form.setJobTitle(employee.getJobTitle());
                form.setVacationHours(employee.getVacationHours());
                form.setProfileImageUrl(employee.getProfileImageUrl());
                form.setOfficeId(employee.getOfficeId());
                form.setReportsTo(employee.getReportsTo());
                response.addObject("form", form);
            } else {
                response.addObject("messageKey", "The employee was not found in the database.");
            }
        }
        List<Employee> employees = employeeDAO.findAll();
        response.addObject("employeesKey", employees);
        return response;
    }
}

