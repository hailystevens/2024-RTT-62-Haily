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
@PreAuthorize("hasAuthority('ADMIN')") // Requirement: Use @PreAuthorize on controller or method
public class AdminController {

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;

    @GetMapping("/dashboard") // Requirement: Have one GET controller method
    public ModelAndView dashboard() {
        ModelAndView response = new ModelAndView("admin/dashboard"); // Maps to the JSP page "admin/dashboard.jsp"

        try {
            User user = authenticatedUserUtilities.getCurrentUser(); // Requirement: Get logged-in user in JSP or Controller
            log.debug("Current admin user: {}", user); // Logging requirement
            response.addObject("user", user); // Passing user data to the view
        } catch (Exception e) {
            log.error("Error retrieving the current user", e); // Logging error scenarios
            response.setViewName("error"); // Redirects to an error page if there's an issue
            response.addObject("errorMessage", "Unable to retrieve the current user information.");
        }

        return response;
    }
}