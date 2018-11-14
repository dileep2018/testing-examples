package com.pik.contact.gui.selenium.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumDriver {

    static private WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
            driver = new FirefoxDriver();    //can be replaced with HtmlUnitDriver for better performance
            FirefoxDriver driver = new FirefoxDriver();
            driver.get("http://54.145.226.14:8081/contact/");
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }
        return driver;
    }

}

