//MyServiceTest.java

package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

/* 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;    */

public class MyServiceTest {
    @Test
    public void testExternalApi() 
    {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        Mockito.when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        Assertions.assertEquals("Mock Data", result);
    }


    @Test
    public void testVerifyInteraction() 
    {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        MyService service = new MyService(mockApi);
        service.fetchData();

        Mockito.verify(mockApi).getData();
    }


    @Test
    public void testArgumentMatching()  
    {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        Mockito.when(mockApi.process(Mockito.anyString())).thenReturn("Processed");

        MyService service = new MyService(mockApi);
        String result = service.processData("input");

        Assertions.assertEquals("Processed", result);
        Mockito.verify(mockApi).process("input");
    }

    @Test
    public void testVoidMethod()
    {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        Mockito.doNothing().when(mockApi).sendData("Hello");

        MyService service = new MyService(mockApi);
        service.pushData("Hello");

        Mockito.verify(mockApi).sendData("Hello");
    }

    @Test
    public void testMultipleReturns() 
    {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        Mockito.when(mockApi.getData())
               .thenReturn("First")
               .thenReturn("Second");

        MyService service = new MyService(mockApi);

        Assertions.assertEquals("First", service.fetchData());
        Assertions.assertEquals("Second", service.fetchData());
    }

    @Test
    public void testInteractionOrder() 
    {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        mockApi.getData();
        mockApi.sendData("Done");

        InOrder inOrder = Mockito.inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).sendData("Done");
    }

    @Test
    public void testVoidMethodThrowsException() 
    {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        Mockito.doThrow(new RuntimeException("Failed"))
                .when(mockApi).sendData("BadData");

        MyService service = new MyService(mockApi);

        Assertions.assertThrows(RuntimeException.class, () -> {
            service.pushData("BadData");
        });
    }

}
