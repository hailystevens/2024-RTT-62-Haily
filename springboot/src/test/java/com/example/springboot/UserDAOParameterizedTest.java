package com.example.springboot;

import com.example.springboot.database.dao.UserDAO;
import com.example.springboot.database.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserDAOParameterizedTest {

    @Autowired
    private UserDAO userDAO;

    @BeforeEach
    public void setUp() {
        userDAO.deleteAll();
    }

    @ParameterizedTest
    @CsvSource({
            "test1@example.com, password1",
            "test2@example.com, password2",
            "test3@example.com, password3"
    })
    public void testCreateUser(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setCreateDate(new Date());

        User savedUser = userDAO.save(user);
        assertNotNull(savedUser);
        assertNotNull(savedUser.getId());

        Optional<User> foundUser = userDAO.findById(savedUser.getId().longValue());
        assertTrue(foundUser.isPresent());
        assertEquals(email, foundUser.get().getEmail());
    }
}
