package com.example;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    @Test
    public void testGetUserById() {
        UserRepository mockRepo = mock(UserRepository.class);
        User user = new User();
        user.setId(1L); user.setName("Test");

        when(mockRepo.findById(1L)).thenReturn(Optional.of(user));

        UserService service = new UserService();
        service.userRepository = mockRepo;

        User result = service.getUserById(1L);
        assertEquals("Test", result.getName());
    }
}