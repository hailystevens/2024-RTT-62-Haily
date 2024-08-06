package com.example.springboot.controller;

import com.example.springboot.database.entity.User;
import com.example.springboot.security.AuthenticatedUserUtilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;

    @GetMapping("/dashboard")
    public ModelAndView dashboard() {
        ModelAndView response = new ModelAndView("admin/dashboard");

        try {
            User user = authenticatedUserUtilities.getCurrentUser();
            log.debug("Current admin user: {}", user);
            response.addObject("user", user);
        } catch (Exception e) {
            log.error("Error retrieving the current user", e);
            response.setViewName("error");
            response.addObject("errorMessage", "Unable to retrieve the current user information.");
        }

        return response;
    }
}
