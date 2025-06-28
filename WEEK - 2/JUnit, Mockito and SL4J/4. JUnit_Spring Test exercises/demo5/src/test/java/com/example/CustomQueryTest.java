package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomQueryTest {
    @Test
    public void testFindByName() 
    {
        UserRepository mockRepo = mock(UserRepository.class);
        User user = new User(); user.setId(2L); user.setName("QueryName");

        when(mockRepo.findByName("QueryName")).thenReturn(List.of(user));

        UserService service = new UserService();
        service.userRepository = mockRepo;

        List<User> users = service.findByName("QueryName");
        assertEquals(1, users.size());
    }
}