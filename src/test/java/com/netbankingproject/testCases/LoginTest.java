package com.netbankingproject.testCases;
import com.netbankingproject.Base.BaseClass;
import com.netbankingproject.Utils.DataProvider.ExcelDataProvider;
import com.netbankingproject.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseClass
{
    @Test(priority = 1, dataProvider = "LoginTestData",dataProviderClass = ExcelDataProvider.class)
    public void login(String uid,String pwd) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserId(uid);
        loginPage.setPassWord(pwd);
        loginPage.goToLogin();

        System.out.println("The Login Id is :" +uid);
        System.out.println("The password is:" +pwd);

         Thread.sleep(3000);

        if (isAlertPresent()==true)
        {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
        }
        else
        {
            Assert.assertTrue(true);

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(3000);
            loginPage.logOut();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }


    }

}