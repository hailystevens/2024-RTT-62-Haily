package com.example.springboot.service;

import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OfficeDAO;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Office;
import com.example.springboot.form.CreateEmployeeFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private OfficeDAO officeDAO;

    public Employee createEmployee(CreateEmployeeFormBean form) {
        log.debug(form.toString());

        Employee employee = employeeDAO.findById(form.getId());
        if (employee == null) {
            employee = new Employee();
        }

        employee.setEmail(form.getEmail());
        employee.setFirstName(form.getFirstName());
        employee.setLastName(form.getLastName());
        employee.setReportsTo(form.getReportsTo());
        employee.setExtension("x357");
        employee.setJobTitle("SomeJob");
        employee.setVacationHours(form.getVacationHours());
        employee.setProfileImageUrl("/public/images/" + form.getFile().getOriginalFilename());

        Office office = officeDAO.findById(form.getOfficeId());
        employee.setOffice(office);

        employee = employeeDAO.save(employee);

        return employee;
    }
}
