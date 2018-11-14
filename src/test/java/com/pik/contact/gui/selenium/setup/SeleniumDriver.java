package com.pik.contact.gui.selenium.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumDriver {

    static private WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            File pathToBinary = new File("/usr/bin/firefox");
            FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);
            driver = new FirefoxDriver();    //can be replaced with HtmlUnitDriver for better performance
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }
        return driver;
    }

}   
