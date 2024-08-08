package com.example.springboot;

import com.example.springboot.database.dao.UserRoleDAO;
import com.example.springboot.database.entity.UserRole;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRoleDAOTest {

    @Autowired
    private UserRoleDAO userRoleDAO;

    private UserRole userRole;

    @BeforeEach
    public void setUp() {
        userRole = new UserRole();
        userRole.setUserId(1); // Assuming a user with id 1 exists
        userRole.setRoleName("USER");
        userRole.setCreateDate(new Date());
    }

    @Test
    @Order(1)
    public void testCreateUserRole() {
        UserRole savedUserRole = userRoleDAO.save(userRole);
        assertNotNull(savedUserRole);
        assertNotNull(savedUserRole.getId());
    }
}