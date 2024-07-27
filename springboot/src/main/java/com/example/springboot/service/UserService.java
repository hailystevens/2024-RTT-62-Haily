package com.example.springboot.service;

import com.example.springboot.database.entity.User;
import com.example.springboot.form.CreateAccountFormBean;
import com.example.springboot.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(CreateAccountFormBean form) {
        if (userRepository.existsByEmail(form.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        User user = new User();
        user.setUsername(form.getUsername());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setCreateDate(new Date());
        userRepository.save(user);
        log.debug("User created with email: " + user.getEmail());
        return user;
    }
}
