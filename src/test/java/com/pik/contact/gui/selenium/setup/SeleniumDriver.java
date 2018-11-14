package com.pik.contact.gui.selenium.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumDriver {

    static private WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            File pathToBinary = new File("/home/ubuntu/.mozilla/firefox/s7hoae7c.default");
            FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
            System.setProperty("webdriver.gecko.driver","/usr/local/bin/geckodriver");
            driver = new FirefoxDriver();    //can be replaced with HtmlUnitDriver for better performance
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }
        return driver;
    }

}   
