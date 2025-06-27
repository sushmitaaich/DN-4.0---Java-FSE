package com.example;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {
    @Test
    public void testServiceWithMockRepository() {
        Repository mockRepo = mock(Repository.class);
        when(mockRepo.getData()).thenReturn("Mock Data");

        Service service = new Service(mockRepo);
        String result = service.processData();

        assertEquals("Processed Mock Data", result);
    }
}

