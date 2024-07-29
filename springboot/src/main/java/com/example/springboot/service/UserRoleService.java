package com.example.springboot.service;

import com.example.springboot.database.dao.UserRoleDAO;
import com.example.springboot.database.entity.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserRoleService {

    @Autowired
    private UserRoleDAO userRoleDAO;

    public UserRole createUserRole(UserRole userRole) {
        return userRoleDAO.save(userRole);
    }

    public UserRole getUserRoleById(Integer id) {
        return userRoleDAO.findById(id).orElse(null);
    }

    public List<UserRole> getAllUserRoles() {
        return userRoleDAO.findAll();
    }

    public void deleteUserRoleById(Integer id) {
        userRoleDAO.deleteById(id);
    }
}
