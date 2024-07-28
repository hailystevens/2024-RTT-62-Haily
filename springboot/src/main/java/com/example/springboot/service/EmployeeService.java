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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

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
        log.info("submit employeeId: {}", employeeId);

        boolean isNewEmployee = employeeId == null;

        if (isNewEmployee) {
            employee = new Employee();
        } else {
            Optional<Employee> employeeOpt = employeeDAO.findById(employeeId);
            if (employeeOpt.isPresent()) {
                employee = employeeOpt.get();
            } else {
                log.error("Employee with id {} not found", employeeId);
                return null;
            }
        }

        if (form.getProfileImage() != null && !form.getProfileImage().isEmpty()) {
            String saveProfileImageName = "./src/main/webapp/assets/img/" + form.getProfileImage().getOriginalFilename();
            try {
                Path savePath = Paths.get(saveProfileImageName);
                Files.copy(form.getProfileImage().getInputStream(), savePath, StandardCopyOption.REPLACE_EXISTING);
                String url = "/assets/img/" + form.getProfileImage().getOriginalFilename();
                employee.setProfileImageUrl(url);
            } catch (Exception e) {
                log.error("Unable to finish reading file", e);
            }
        }

        employee.setEmail(form.getEmail());
        employee.setFirstname(form.getFirstname());
        employee.setLastname(form.getLastname());
        employee.setReportsTo(form.getReportsTo());
        employee.setExtension(form.getExtension());
        employee.setJobTitle(form.getJobTitle());
        employee.setVacationHours(form.getVacationHours());

        Optional<Office> officeOpt = officeDAO.findById(form.getOfficeId());
        if (officeOpt.isPresent()) {
            employee.setOffice(officeOpt.get());
        } else {
            log.error("Office with id {} not found", form.getOfficeId());
            return null;
        }

        employee = employeeDAO.save(employee);
        return employee;
    }
}
