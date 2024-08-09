package com.example.springboot.service;

import com.example.springboot.database.dao.UserDAO;
import com.example.springboot.database.dao.UserRoleDAO;
import com.example.springboot.database.entity.User;
import com.example.springboot.database.entity.UserRole;
import com.example.springboot.form.CreateAccountFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO; // Requirement: Create one DAO/Repository for each table

    @Autowired
    private UserRoleDAO userRoleDAO; // Requirement: Create one DAO/Repository for each table

    @Autowired
    private PasswordEncoder passwordEncoder; // Requirement: Proper use of password encryption to write to database

    public void createUser(CreateAccountFormBean form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword())); // Requirement: Proper use of password encryption to write to database
        user.setCreateDate(new Date()); // Sets the creation date of the user

        userDAO.save(user); // Saves the user entity in the database

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId()); // Links the user role to the newly created user
        userRole.setRoleName("USER"); // Assigns the "USER" role to the new user
        userRole.setCreateDate(new Date()); // Sets the creation date of the user role

        userRoleDAO.save(userRole); // Saves the user role entity in the database
    }
}