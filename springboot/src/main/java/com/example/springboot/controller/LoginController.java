package com.example.springboot.controller;

import com.example.springboot.form.CreateAccountFormBean;
import com.example.springboot.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/account")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/create-account")
    public ModelAndView createAccount() {
        ModelAndView response = new ModelAndView("auth/create-account");
        response.addObject("form", new CreateAccountFormBean());
        return response;
    }

    @PostMapping("/create-account")
    public ModelAndView createAccountSubmit(@Valid CreateAccountFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView("auth/create-account");

        if (bindingResult.hasErrors()) {
            response.addObject("form", form);  // Add the form object back to the model
            bindingResult.getAllErrors().forEach(error -> {
                if (error instanceof FieldError) {
                    log.debug("Validation error: " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
                } else {
                    log.debug("Validation error: " + error.getObjectName() + " = " + error.getDefaultMessage());
                }
            });
            response.addObject("bindingResult", bindingResult);
        } else {
            try {
                userService.createUser(form);
                response.addObject("message", "User created successfully");
                response.setViewName("redirect:/account/create-account");  // Redirect to avoid duplicate submissions
            } catch (IllegalArgumentException e) {
                bindingResult.rejectValue("email", "error.form", e.getMessage());
                response.addObject("form", form);  // Add the form object back to the model
                response.addObject("bindingResult", bindingResult);
            }
        }

        return response;
    }

}
