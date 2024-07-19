package com.apiautomation.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
    public static String getProperty(String key){
        Properties properties = new Properties();
        try{
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/data.properties");
            properties.load(fileInputStream);
            return properties.getProperty(key);
        }
        catch (Exception exception){
            return exception.getMessage();
        }
    }
}
