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

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()  // Disable CSRF protection
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/product/list", "/product/detail/**", "/order/addToCart", "/order/viewCart", "/order/removeFromCart/**").permitAll()
                        // Allow public access to product pages and cart functionality
                        .requestMatchers("/order/list", "/product/create", "/product/edit/**", "/product/delete/**").hasRole("ADMIN") // Restrict these pages to admins
                        .anyRequest().permitAll()); // Allow public access to all other pages

        http.formLogin()
                .loginPage("/account/login")
                .loginProcessingUrl("/account/loginProcessingURL")
                .defaultSuccessUrl("/product/list", true)
                .failureUrl("/account/login?error=true");

        http.logout()
                .invalidateHttpSession(true)
                .logoutUrl("/account/logout")
                .logoutSuccessUrl("/");

        http.exceptionHandling()
                .accessDeniedPage("/access-denied");

        return http.build();
    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
