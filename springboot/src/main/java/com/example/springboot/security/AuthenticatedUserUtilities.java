package com.example.springboot.security;

import com.example.springboot.database.dao.UserDAO;
import com.example.springboot.database.entity.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Slf4j
@Component
public class AuthenticatedUserUtilities {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String getCurrentUsername() {
        // Return the logged-in username or null if not logged in
        SecurityContext context = SecurityContextHolder.getContext();
        if (context != null && context.getAuthentication() != null) {
            if (context.getAuthentication() instanceof AnonymousAuthenticationToken) {
                return null;
            }
            final org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) context.getAuthentication().getPrincipal();
            return principal.getUsername();
        } else {
            return null;
        }
    }

    public User getCurrentUser() {
        // Return the logged-in user object or null if not logged in
        String username = getCurrentUsername();
        if (username == null) {
            return null;
        }
        return userDAO.findByEmailIgnoreCase(username);
    }

    public void manualAuthentication(HttpSession session, String username, String unencryptedPassword) {
        // Authenticate the user manually and set the security context
        Authentication request = new UsernamePasswordAuthenticationToken(username, unencryptedPassword);
        Authentication result = authenticationManager.authenticate(request);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(result);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, sc);
    }

    public boolean isUserInRole(String role) {
        // Check if the current user has the specified role
        SecurityContext context = SecurityContextHolder.getContext();
        if (context != null && context.getAuthentication() != null) {
            Collection<? extends GrantedAuthority> authorities = context.getAuthentication().getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(role)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAuthenticated() {
        // Check if there is an authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return false;
        }
        return (authentication != null && authentication.isAuthenticated());
    }
}
