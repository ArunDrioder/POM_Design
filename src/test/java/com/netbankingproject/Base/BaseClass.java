package com.netbankingproject.Base;

import com.netbankingproject.Utils.Readers.ConfigReader.ConfigReaderClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass
{
static ConfigReaderClass readerClass;
public static WebDriver driver;
public static String browserName;
public static String baseURL;

    static {
        try {
            readerClass = new ConfigReaderClass();
             baseURL = readerClass.getURL();
            browserName = readerClass.getBrowser();
            }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public void setUp()
    {
        if(browserName.equals("chrome"))
        {
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            driver = new ChromeDriver();
        }

        else if (browserName.equals("firefox"))
        {
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }


    public boolean isAlertPresent()
    {
        try {
            driver.switchTo().alert();
            return true;
           }
        catch (NoAlertPresentException e)
        {
            return false;
        }



    }



}
