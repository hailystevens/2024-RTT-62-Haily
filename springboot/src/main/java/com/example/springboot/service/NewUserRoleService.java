package com.example.springboot.service;

import com.example.springboot.database.dao.NewUserRoleDAO;
import com.example.springboot.database.entity.NewUserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NewUserRoleService {

    @Autowired
    private NewUserRoleDAO newUserRoleDAO;

    public NewUserRole createNewUserRole(NewUserRole newUserRole) {
        return newUserRoleDAO.save(newUserRole);
    }

    public NewUserRole getNewUserRoleById(Integer id) {
        return newUserRoleDAO.findById(id).orElse(null);
    }

    public List<NewUserRole> getAllNewUserRoles() {
        return newUserRoleDAO.findAll();
    }

    public void deleteNewUserRoleById(Integer id) {
        newUserRoleDAO.deleteById(id);
    }
}
