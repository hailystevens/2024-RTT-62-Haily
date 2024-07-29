package com.example.springboot.service;

import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OfficeDAO;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Office;
import com.example.springboot.form.CreateEmployeeFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private OfficeDAO officeDAO;

    public Employee createEmployee(CreateEmployeeFormBean form) {
        log.debug(form.toString());

        Employee employee = employeeDAO.findById(form.getId()).orElse(new Employee());

        employee.setEmail(form.getEmail());
        employee.setFirstName(form.getFirstName());
        employee.setLastName(form.getLastName());
        employee.setReportsTo(form.getReportsTo());
        employee.setExtension(form.getExtension());
        employee.setJobTitle(form.getJobTitle());
        employee.setVacationHours(form.getVacationHours());
        employee.setProfileImageUrl("/public/images/" + form.getFile().getOriginalFilename());

        Office office = officeDAO.findById(form.getOfficeId()).orElse(null);
        if (office != null) {
            employee.setOffice(office);
        } else {
            log.error("Office ID " + form.getOfficeId() + " not found");
        }

        // Handle file upload
        MultipartFile file = form.getFile();
        if (!file.isEmpty()) {
            String filename = file.getOriginalFilename();
            try {
                Files.copy(file.getInputStream(), Paths.get("src/main/webapp/public/images/" + filename), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                log.error("Error saving file: " + filename, e);
            }
        }

        employee = employeeDAO.save(employee);

        return employee;
    }
}
