package com.company;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class gridtest {
    public static void main(String [] args) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");
        desiredCapabilities.setPlatform(Platform.WIN10);
        WebDriver driver = new RemoteWebDriver(new URL(" http://192.168.1.34:4444/wd/hub"),desiredCapabilities);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println("Title of the page is :" + driver.getTitle());
        driver.quit();
    }
}
