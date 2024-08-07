package com.example.springboot.controller;

import com.example.springboot.database.dao.UserDAO;
import com.example.springboot.database.entity.User;
import com.example.springboot.form.CreateAccountFormBean;
import com.example.springboot.security.AuthenticatedUserUtilities;
import com.example.springboot.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;

    @GetMapping("/login")
    public ModelAndView doLogin() {
        return new ModelAndView("auth/login");
    }

    @GetMapping("/create-account")
    public ModelAndView createAccount() {
        return new ModelAndView("auth/create-account");
    }

    @PostMapping("/create-account")
    public ModelAndView createAccountSubmit(@Valid CreateAccountFormBean form, BindingResult bindingResult, HttpSession session) {
        ModelAndView response = new ModelAndView("auth/create-account");

        log.debug("CreateAccountFormBean: " + form.toString());

        if (form.getId() == null) {
            User u = userDAO.findByEmailIgnoreCase(form.getEmail());
            log.debug("User found by email: " + u);

            if (u != null) {
                bindingResult.rejectValue("email", "email", "This email is already in use.");
            }
        }

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
        } else {
            try {
                userService.createUser(form);
                authenticatedUserUtilities.manualAuthentication(session, form.getEmail(), form.getPassword());
                response.setViewName("redirect:/index");
            } catch (Exception e) {
                log.error("Error creating account", e);
                response.setViewName("error/500");
            }
        }
        return response;
    }
}
