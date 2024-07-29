package com.example.springboot.validation;

import com.example.springboot.database.dao.EmployeeDAO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeEmailUniqueValidator implements ConstraintValidator<EmployeeEmailUnique, String> {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public void initialize(EmployeeEmailUnique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.isEmpty()) {
            return true; // Skip validation for null or empty values, use @NotEmpty for that
        }

        return employeeDAO.findByEmailIgnoreCase(email) == null;
    }
}
