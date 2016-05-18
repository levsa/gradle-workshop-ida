package com.iipax.edu;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class DefaultService implements Service
{
    @Override
    public String getVersion()
    {
        Properties properties = new Properties();
        try
        {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("version.properties");
            if (inputStream != null)
            {
                properties.load(inputStream);
            }
        }
        catch (IOException e)
        {
            properties.setProperty("version", "<ERROR>");
        }
        return properties.getProperty("version", "UNDEFINED");
    }

}
