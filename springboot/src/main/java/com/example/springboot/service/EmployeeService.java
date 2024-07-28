
package com.example.springboot.service;

import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OfficeDAO;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Office;
import com.example.springboot.form.CreateEmployeeFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@Component
public class EmployeeService {


    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private OfficeDAO officeDAO;


    public Employee createEmployee(CreateEmployeeFormBean form) {
        Employee employee;
        Integer employeeId = form.getId();
        log.info("submit employeeId: " + employeeId);

        boolean isNewEmployee = employeeId == null;

        if (isNewEmployee) {
            employee = new Employee();
        } else {
            employee = employeeDAO.findById(employeeId);

        }

        String saveProfileImageName = "./src/main/webapp/assets/img/" + form.getProfileImage().getOriginalFilename();
        try {
            Files.copy(form.getProfileImage().getInputStream(), Paths.get(saveProfileImageName), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            log.error("Unable to finish reading file", e);
        }


        String url = "/assets/img/" + form.getProfileImage().getOriginalFilename();

        employee.setProfileImageUrl(url);
        employee.setEmail(form.getEmail());
        employee.setFirstname(form.getFirstname());
        employee.setLastname(form.getLastname());
        employee.setReportsTo(form.getReportsTo());
        employee.setExtension(form.getExtension());
        employee.setJobTitle(form.getJobTitle());
        employee.setVacationHours(form.getVacationHours());


        Office office = officeDAO.findById(form.getOfficeId());
        employee.setOffice(office);

        employee = employeeDAO.save(employee);

        return employee;
    }
}
