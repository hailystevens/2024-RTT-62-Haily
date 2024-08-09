package com.example.springboot.controller;

import com.example.springboot.database.dao.UserDAO;
import com.example.springboot.form.CreateAccountFormBean;
import com.example.springboot.security.AuthenticatedUserUtilities;
import com.example.springboot.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid; // Requirement: Form bean with 2 different validation annotations
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult; // Requirement: Use @Valid with BindingResult (not on registration page)
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; // Requirement: Have one POST controller method
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/login") // Requirement: Working login page
    public ModelAndView doLogin() {
        return new ModelAndView("auth/login"); // Maps to login.jsp
    }

    @GetMapping("/create-account")
    public ModelAndView createAccount() {
        log.debug("Accessing create account page");
        ModelAndView response = new ModelAndView("auth/create-account"); // Maps to create-account.jsp
        response.addObject("form", new CreateAccountFormBean()); // Add form bean to the view
        return response;
    }

    @PostMapping("/create-account") // Requirement: Have one POST controller method
    public ModelAndView createAccountSubmit(@Valid CreateAccountFormBean form, BindingResult bindingResult, HttpSession session, RedirectAttributes redirectAttributes) {
        ModelAndView response = new ModelAndView("auth/create-account");

        if (bindingResult.hasErrors()) { // Validate form inputs
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
        } else {
            try {
                userService.createUser(form); // Create user and save to the database
                authenticatedUserUtilities.manualAuthentication(session, form.getEmail(), form.getPassword()); // Log the user in after account creation
                log.debug("User created and authenticated successfully");

                // Add flash attribute for success message
                redirectAttributes.addFlashAttribute("successMessage", "Account created successfully!");

                response.setViewName("redirect:/account/create-account-success"); // Redirect to success page
            } catch (Exception e) {
                log.error("Error creating account", e);
                response.setViewName("error/500"); // Redirect to 500 error page if there's an issue
            }
        }

        return response;
    }

    @GetMapping("/create-account-success")
    public ModelAndView createAccountSuccess() {
        return new ModelAndView("auth/create-account-success"); // Maps to create-account-success.jsp
    }
}