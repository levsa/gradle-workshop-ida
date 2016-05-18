package com.iipax.edu;

import java.io.PrintStream;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ApplicationTest
{
    @Test
    public void callsServiceToPrintVersion()
    {
        String testVersion = "testversion-1.0";
        Service service = mock(Service.class);
        when(service.getVersion()).thenReturn(testVersion);
        Application application = new Application(service);
        PrintStream printStream = mock(PrintStream.class);
        application.printVersion(printStream);
        verify(printStream).println("Application version: " + testVersion);
    }
}
