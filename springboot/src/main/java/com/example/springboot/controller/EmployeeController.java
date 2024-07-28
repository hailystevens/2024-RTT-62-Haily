package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OfficeDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Office;
import com.example.springboot.form.CreateEmployeeFormBean;
import com.example.springboot.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private CustomerDAO customerDAO;

    @Autowired
    private OfficeDAO officeDAO;

    @Autowired
    private EmployeeService employeeService;

    private void addEmployeesAndOfficesToResponse(ModelAndView response) {
        List<Employee> employees = employeeDAO.findAll();
        response.addObject("employees", employees);

        List<Office> offices = officeDAO.findAll();
        response.addObject("offices", offices);
    }

    @GetMapping("/search")
    public ModelAndView employeeSearch(@RequestParam(required = false) String search) {
        log.info("Search term is: " + search);
        ModelAndView response = new ModelAndView("employeeSearch");
        List<Employee> employees = employeeDAO.findByName(search);
        response.addObject("search", search);
        response.addObject("employees", employees);
        return response;
    }

    @GetMapping("/detail")
    public ModelAndView employeeDetails(@RequestParam Integer employeeId) {
        ModelAndView response = new ModelAndView("employeeDetails");

        Optional<Employee> employeeOpt = employeeDAO.findById(employeeId);
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            response.addObject("employee", employee);

            if (employee.getOfficeId() != null) {
                response.addObject("employeeOffice", officeDAO.findById(employee.getOfficeId()).orElse(null));
            }

            List<Customer> customers = customerDAO.findByEmployeeId(employeeId);
            response.addObject("customers", customers);
        } else {
            // Handle the case where the employee is not found
            response.setViewName("error/404");
        }

        return response;
    }

    @GetMapping("/create")
    public ModelAndView createEmployee() {
        ModelAndView response = new ModelAndView("createEmployee");
        addEmployeesAndOfficesToResponse(response);
        return response;
    }

    @PostMapping("/createSubmit")
    public ModelAndView createEmployeeSubmit(@Valid CreateEmployeeFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        log.info("submit form: " + form.toString());

        if (form.getId() == null) {
            Employee e = employeeDAO.findByEmailIgnoreCase(form.getEmail());
            if (e != null) {
                bindingResult.rejectValue("email", "email", "This email is already in use, (Manual check)");
            }
        }

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
            addEmployeesAndOfficesToResponse(response);

            response.setViewName("createEmployee");
            return response;
        }

        Employee employee = employeeService.createEmployee(form);
        response.setViewName("redirect:/employee/detail?employeeId=" + employee.getId());
        return response;
    }

    @GetMapping("/edit")
    public ModelAndView editEmployee(@RequestParam(required = false) Integer employeeId) {
        ModelAndView response = new ModelAndView("createEmployee");
        addEmployeesAndOfficesToResponse(response);

        log.info("edit employeeId: " + employeeId);

        if (employeeId != null) {
            Optional<Employee> employeeOpt = employeeDAO.findById(employeeId);
            if (employeeOpt.isPresent()) {
                Employee employee = employeeOpt.get();
                CreateEmployeeFormBean form = new CreateEmployeeFormBean();
                form.setId(employee.getId());
                form.setEmail(employee.getEmail());
                form.setFirstname(employee.getFirstname());
                form.setLastname(employee.getLastname());
                form.setJobTitle(employee.getJobTitle());
                form.setOfficeId(employee.getOfficeId());
                form.setExtension(employee.getExtension());
                form.setVacationHours(employee.getVacationHours());
                form.setReportsTo(employee.getReportsTo());
                form.setProfileImageUrl(employee.getProfileImageUrl());
                response.addObject("form", form);
            }
        }
        return response;
    }
}
