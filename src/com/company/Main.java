package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        System.out.println("hello start");
        System.setProperty("webdriver.chrome.driver","F:\\corona semester\\software tools E\\final drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.name("q")).sendKeys("facebook");
        Thread.sleep(10000);
        List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
        System.out.println(list.size());
        for(int i = 0;i<list.size();i++)
        {
            String listitem = list.get(i).getText();
            System.out.println(listitem);
            if(listitem.contains("facebook"))
            {
                list.get(i).click();
                break;
            }
        }
    }
}
