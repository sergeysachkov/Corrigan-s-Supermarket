package com.ait.corrigan.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by root on 1/21/2017.
 */
public class DBPropertyUtil {
    private Properties properties;

    public DBPropertyUtil() throws IOException {
        this.properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("db.properties");

        if (inputStream != null) {
            properties.load(inputStream);
        }
    }

    public String getProperty(String prop){
        return properties.getProperty(prop);
    }
}
