package com.example.springboot.service;

import com.example.springboot.database.dao.NewUserDAO;
import com.example.springboot.database.entity.NewUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NewUserService {

    @Autowired
    private NewUserDAO newUserDAO;

    public NewUser createNewUser(NewUser newUser) {
        return newUserDAO.save(newUser);
    }

    public NewUser getNewUserById(Integer id) {
        return newUserDAO.findById(id).orElse(null);
    }

    public List<NewUser> getAllNewUsers() {
        return newUserDAO.findAll();
    }

    public void deleteNewUserById(Integer id) {
        newUserDAO.deleteById(id);
    }
}
