package com.thetestingacademy.pages;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.driver.DriverManagerTL;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.thetestingacademy.driver.DriverManagerTL.getDriver;

public class LoginPage extends CommonToAllPage {
    //WebDriver
    //Page class
    //Page locators
    //Page Actions
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = DriverManagerTL.getDriver();

    }
    // // Step 1 - Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");
    private By Dashboard=By.xpath("//h6[text()='Amcret']");
    public String loginToVWOLoginInvalidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);
        WaitHelpers.checkVisibility(getDriver(),error_message);
        return getText(error_message);
    }
    public void loginToVWOLoginValidCreds(String user, String pwd) {

        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);

        // Wait - Thread sleep
        WaitHelpers.waitJVM(5000);

    }

}
