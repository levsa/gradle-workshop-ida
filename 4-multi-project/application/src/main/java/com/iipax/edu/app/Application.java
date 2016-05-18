package com.iipax.edu;

import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iipax.edu.api.Service;
import com.iipax.edu.backend.DefaultService;

public class Application
{
    private Service service;
    private static Logger LOG = LoggerFactory.getLogger(Application.class);

    public Application(Service service)
    {
        this.service = service;
    }

    public void printVersion(PrintStream printStream)
    {
        String version = service.getVersion();
        LOG.debug("Printing version: " + version);
        printStream.println("Application version: " + version);
    }

    public static void main(String[] args)
    {
        Application application = new Application(new DefaultService());
        application.printVersion(System.out);
    }

}
