package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceExceptionTest {
    @Test
    public void testExceptionHandling() {
        UserService service = new UserService();
        assertThrows(Exception.class, () -> {
            service.getUserById(999L);
        });
    }
}