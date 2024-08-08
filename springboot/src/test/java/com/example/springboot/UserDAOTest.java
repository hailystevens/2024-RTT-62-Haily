package com.example.springboot;

import com.example.springboot.database.dao.UserDAO;
import com.example.springboot.database.entity.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setCreateDate(new Date());
    }

    @Test
    @Order(1)
    public void testCreateUser() {
        User savedUser = userDAO.save(user);
        assertNotNull(savedUser);
        assertNotNull(savedUser.getId());
    }

    @Test
    @Order(2)
    public void testReadUser() {
        User savedUser = userDAO.save(user);
        Optional<User> foundUser = userDAO.findById(savedUser.getId().longValue());
        assertTrue(foundUser.isPresent());
        assertEquals(user.getEmail(), foundUser.get().getEmail());
    }

    @Test
    @Order(3)
    public void testUpdateUser() {
        User savedUser = userDAO.save(user);
        savedUser.setPassword("newpassword");
        User updatedUser = userDAO.save(savedUser);
        assertEquals("newpassword", updatedUser.getPassword());
    }

    @Test
    @Order(4)
    public void testDeleteUser() {
        User savedUser = userDAO.save(user);
        userDAO.delete(savedUser);
        Optional<User> foundUser = userDAO.findById(savedUser.getId().longValue());
        assertFalse(foundUser.isPresent());
    }
}
