package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class IntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testEndToEndSaveAndFetchUser() {
        User user = new User(); user.setId(100L); user.setName("IntegrationTest");
        userService.saveUser(user);
        User fetched = userService.getUserById(100L);
        assertEquals("IntegrationTest", fetched.getName());
    }
}