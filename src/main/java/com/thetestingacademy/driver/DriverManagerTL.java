package com.thetestingacademy.driver;

import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManagerTL {
    //ThreadLocal code start
    public static final ThreadLocal<WebDriver> driver1 = new ThreadLocal<>();


    public static void setDriver(WebDriver driverRef){
        driver1.set(driverRef);
    }

    public static WebDriver getDriver(){
        return driver1.get();
    }

    // Unload
    public static void unload(){
        driver1.remove();
    }
    //ThreadLocal code ends
    //Other functions are same
    public static void init() {
        String browser = PropertiesReader.readKey("browser");
        browser = browser.toLowerCase();

        switch (browser) {
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--guest");
                setDriver(new EdgeDriver(edgeOptions));
                break;
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                setDriver(new ChromeDriver(chromeOptions));
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                setDriver(new FirefoxDriver(firefoxOptions));
                break;
            default:
                System.out.println("Browser not supported!!!");
        }


    }
    // When we want to close the browser

    public static void down() {
        if (getDriver() != null) {
            getDriver().quit();
            unload(); // Removes WebDriver instance from ThreadLocal
        }
    }
}
