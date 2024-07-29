package com.example.springboot.controller;

import com.example.springboot.database.dao.UserDAO;
import com.example.springboot.database.entity.User;
import com.example.springboot.form.CreateAccountFormBean;
import com.example.springboot.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userService;

    @GetMapping("/create-account")
    public ModelAndView createAccount() {
        return new ModelAndView("auth/create.jsp-account");
    }

    @PostMapping("/create-account")
    public ModelAndView createAccountSubmit(@Valid CreateAccountFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView("auth/create.jsp-account");

        if (form.getId() == null && userDAO.findByEmail(form.getEmail()).isPresent()) {
            bindingResult.rejectValue("email", "email", "This email is already in use.");
        }

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error: " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
        } else {
            userService.createUser(form);
            response.setViewName("redirect:/user/login");
        }

        return response;
    }

    @GetMapping("/login")
    public ModelAndView doLogin() {
        return new ModelAndView("auth/login");
    }

    @GetMapping("/list")
    public ModelAndView listUsers() {
        ModelAndView response = new ModelAndView("user/list");
        List<User> users = userDAO.findAll();
        response.addObject("users", users);
        return response;
    }

}
