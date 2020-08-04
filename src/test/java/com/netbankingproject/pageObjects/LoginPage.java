package com.netbankingproject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    WebDriver driver;

    public LoginPage(WebDriver webDriver)
    {
        driver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(name = "uid")
    WebElement userID;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "btnLogin")
    WebElement loginBtn;

    @FindBy(linkText = "Log out")
    WebElement logOutBtn;


    public void setUserId(String userId)
    {
        userID.sendKeys(userId);
    }

    public void setPassWord(String passWord)
    {
        password.sendKeys(passWord);

    }

    public void goToLogin()
    {
        loginBtn.click();
    }

    public void logOut()
    {
        logOutBtn.click();
    }
}
