package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // Requirement: Use @PreAuthorize on controller or method
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Disable CSRF protection
        http.csrf().disable();

        // Requirement: Spring Security configuration
        http.authorizeRequests()
                .requestMatchers(new AntPathRequestMatcher("/admin/**"),
                        new AntPathRequestMatcher("/user/**")).authenticated() // Requirement: Use JSP <sec:authorize> for isAuthenticated and isAnyAuthority
                .anyRequest().permitAll();

        // Requirement: Working login page
        http.formLogin()
                .loginPage("/account/login") // Custom login page
                .loginProcessingUrl("/account/loginProcessingURL");

        // Configure logout
        http.logout()
                .invalidateHttpSession(true)
                .logoutUrl("/account/logout") // Custom logout URL
                .logoutSuccessUrl("/");

        return http.build();
    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        // Requirement: Proper use of password encryption to write to the database
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
