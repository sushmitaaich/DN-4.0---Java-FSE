package com.example;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileServiceTest {
    @Test
    public void testServiceWithMockFileIO() {
        FileReader mockReader = mock(FileReader.class);
        FileWriter mockWriter = mock(FileWriter.class);
        when(mockReader.read()).thenReturn("Mock File Content");

        FileService service = new FileService(mockReader, mockWriter);
        String result = service.processFile();

        assertEquals("Processed Mock File Content", result);
        verify(mockWriter).write("Processed Mock File Content");
    }
}
