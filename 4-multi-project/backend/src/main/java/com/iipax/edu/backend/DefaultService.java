package com.iipax.edu.backend;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iipax.edu.api.Service;

public class DefaultService implements Service
{
    private static final String VERSION_PROPERTIES = "version.properties";
    private static Logger LOG = LoggerFactory.getLogger(DefaultService.class);

    @Override
    public String getVersion()
    {
        Properties properties = new Properties();
        try
        {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(VERSION_PROPERTIES);
            if (inputStream != null)
            {
                properties.load(inputStream);
                LOG.debug("Loaded " + VERSION_PROPERTIES);
            }
            else
            {
                LOG.error("Failed to open stream for " + VERSION_PROPERTIES);
            }
        }
        catch (IOException e)
        {
            LOG.error("IOException reading " + VERSION_PROPERTIES, e);
            properties.setProperty("version", "<ERROR>");
        }
        return properties.getProperty("version", "UNDEFINED");
    }

}
