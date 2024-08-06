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

    public void createUser(CreateAccountFormBean form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setCreateDate(new Date());

        userDAO.save(user);

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleName("USER");
        userRole.setCreateDate(new Date());

        userRoleDAO.save(userRole);
    }
}
