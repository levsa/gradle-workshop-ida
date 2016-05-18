package com.iipax.edu;

import java.io.PrintStream;

public class Application
{
    private Service service;

    public Application(Service service)
    {
        this.service = service;
    }

    public void printVersion(PrintStream printStream)
    {
        printStream.println("Application version: " + service.getVersion());
    }

    public static void main(String[] args)
    {
        Application application = new Application(new DefaultService());
        application.printVersion(System.out);
    }

}
