package com.example.springboot.controller;

import com.example.springboot.form.CreateAccountFormBean;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/createUser")
    public String showCreateUserPage(Model model) {
        model.addAttribute("createAccountFormBean", new CreateAccountFormBean());
        return "createUser";
    }

    @PostMapping("/users/create")
    public String createUser(@ModelAttribute CreateAccountFormBean form, Model model) {
        try {
            userService.createUser(form);
            model.addAttribute("message", "User created successfully");
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", "Error: " + e.getMessage());
        }
        return "createUser";
    }
}
