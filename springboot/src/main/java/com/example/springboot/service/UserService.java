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
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(CreateAccountFormBean form, boolean isAdmin) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setCreateDate(new Date());

        userDAO.save(user); // Save the user entity in the database

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleName(isAdmin ? "ROLE_ADMIN" : "ROLE_USER"); // Assign role based on isAdmin flag with prefix ROLE_
        userRole.setCreateDate(new Date());

        userRoleDAO.save(userRole); // Save the user role entity in the database
    }
}
