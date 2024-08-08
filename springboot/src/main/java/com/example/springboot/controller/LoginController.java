package com.example.springboot.controller;

import com.example.springboot.database.dao.UserDAO;
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

    @GetMapping("/login")
    public ModelAndView doLogin() {
        return new ModelAndView("auth/login");
    }

    @GetMapping("/create-account")
    public ModelAndView createAccount() {
        log.debug("Accessing create account page");
        ModelAndView response = new ModelAndView("auth/create-account");
        response.addObject("form", new CreateAccountFormBean());
        return response;
    }

    @PostMapping("/create-account")
    public ModelAndView createAccountSubmit(@Valid CreateAccountFormBean form, BindingResult bindingResult, HttpSession session, RedirectAttributes redirectAttributes) {
        ModelAndView response = new ModelAndView("auth/create-account");

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
                log.debug("User created and authenticated successfully");

                // Add flash attribute for success message
                redirectAttributes.addFlashAttribute("successMessage", "Account created successfully!");

                response.setViewName("redirect:/account/create-account-success");
            } catch (Exception e) {
                log.error("Error creating account", e);
                response.setViewName("error/500");
            }
        }

        return response;
    }
    @GetMapping("/create-account-success")
    public ModelAndView createAccountSuccess() {
        return new ModelAndView("auth/create-account-success");
    }
}
