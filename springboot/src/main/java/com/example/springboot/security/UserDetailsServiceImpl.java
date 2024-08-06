package com.example.springboot.security;

import com.example.springboot.database.dao.UserDAO;
import com.example.springboot.database.dao.UserRoleDAO;
import com.example.springboot.database.entity.User;
import com.example.springboot.database.entity.UserRole;
import com.example.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch the user from the database
        User user = userDAO.findByEmailIgnoreCase(username);

        // Throw an exception if the user is not found in the database
        if (user == null) {
            throw new UsernameNotFoundException("Username '" + username + "' not found in the database.");
        }

        // Define the account status
        boolean accountIsEnabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        // Retrieve user roles from the database
        List<UserRole> userRoles = userRoleDAO.findByUserId(user.getId());

        // Create the authorities (roles) for the user
        Collection<? extends GrantedAuthority> authorities = buildGrantAuthorities(userRoles);

        // Create the UserDetails object
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(),          // Username
                user.getPassword(),       // Password
                accountIsEnabled,         // Account is enabled
                accountNonExpired,        // Account is non-expired
                credentialsNonExpired,    // Credentials are non-expired
                accountNonLocked,         // Account is non-locked
                authorities               // Authorities (roles)
        );

        return userDetails;
    }

    private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Convert user roles to GrantedAuthority objects
        for (UserRole role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }
}
