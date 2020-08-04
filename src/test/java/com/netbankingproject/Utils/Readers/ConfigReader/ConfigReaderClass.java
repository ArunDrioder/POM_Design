package com.netbankingproject.Utils.Readers.ConfigReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderClass
{
    public static Properties prop;

    public ConfigReaderClass() throws IOException
    {
        File configFilePath = new File("C:\\Backup\\Selenium - Workspace\\POM_Design\\Configuration\\config.properties");
        try {
            FileInputStream fiStream = new FileInputStream(configFilePath);
            prop = new Properties();
            prop.load(fiStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    public String getBrowser()
    {
        String browserName = prop.getProperty("browser");
        return browserName;
    }


    public String getURL()
    {
        String launchURL = prop.getProperty("baseURL");
        return launchURL;

    }

}
