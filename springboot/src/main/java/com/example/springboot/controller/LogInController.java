package com.example.springboot.controller;

import com.example.springboot.database.dao.UserDAO;
import com.example.springboot.database.entity.User;
import com.example.springboot.form.CreateAccountFormBean;
import com.example.springboot.form.LoginFormBean;
import com.example.springboot.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/account")
public class LogInController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/create-account")
    public ModelAndView createAccount() {
        return new ModelAndView("auth/create-account");
    }

    @PostMapping("/create-account")
    public ModelAndView createAccountSubmit(@Valid CreateAccountFormBean form, BindingResult bindingResult, HttpSession session) {
        ModelAndView response = new ModelAndView("auth/create-account");
        log.info("submit form: " + form.toString());

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
            return response;
        }

        User user = userService.createUser(form);
        session.setAttribute("user", user);
        return new ModelAndView("redirect:/account/success");
    }

    @GetMapping("/login")
    public ModelAndView getLogin() {
        return new ModelAndView("auth/login");
    }

    @PostMapping("/login")
    public ModelAndView loginSubmit(@Valid LoginFormBean form, BindingResult bindingResult, HttpSession session) {
        ModelAndView response = new ModelAndView("auth/login");
        log.info("submit form: " + form.toString());

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
            return response;
        }

        User user = userDAO.findByEmailIgnoreCase(form.getEmail());
        if (user == null || !passwordEncoder.matches(form.getPassword(), user.getPassword())) {
            bindingResult.reject("login", "Invalid email or password");
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
            return response;
        }

        session.setAttribute("user", user);
        return new ModelAndView("redirect:/account/welcome");
    }

    @GetMapping("/success")
    public ModelAndView accountCreated() {
        ModelAndView response = new ModelAndView("auth/success");
        response.addObject("message", "Account created!");
        return response;
    }

    @GetMapping("/welcome")
    public ModelAndView welcomeBack() {
        ModelAndView response = new ModelAndView("auth/welcome");
        response.addObject("message", "Welcome back!");
        return response;
    }
}
