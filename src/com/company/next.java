package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class next {
    public static void main(String [] args) throws InterruptedException {
        String [] usernames = new String[1];
        usernames[0] = "gurramchandrakishore@gmail.com";
        String [] pass = new String[4];
        pass[0] = "fpass";pass[1] = "spass";pass[2] = "tpass";pass[3] = "17MIS0066";
        System.setProperty("webdriver.chrome.driver","F:\\corona semester\\software tools E\\final drivers\\chromedriver.exe");
        for(int i = 0;i<usernames.length;i++) {
            for (int j = 0; j < pass.length; j++) {
                WebDriver driver = new ChromeDriver();
                driver.get("https://www.qwiklabs.com/");
                System.out.println("Successfully opened qwiklabs");
                driver.manage().window().maximize();
                //Thread.sleep(3000);
                driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/a[3]")).click();
                //Thread.sleep(3000);
                driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/form[2]/div[1]/div/div/input")).sendKeys(usernames[i]);
                driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/form[2]/div[2]/div/div/div/input")).sendKeys(pass[j]);
                driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/form[2]/div[4]/button")).click();

                //Thread.sleep(3000);
                try {
                    driver.findElement(By.xpath("/html/body/div[1]/div[1]/a")).click();
                } catch (NoSuchElementException e) {
                    System.out.println("Invalid Test Case");
                    driver.close();
                    continue;
                }

                System.out.println("Login Successfull");
                System.out.println("navigation drawer successfull");
                //Thread.sleep(3000);
                driver.findElement(By.xpath("/html/body/nav[2]/a[2]")).click();
                System.out.println("catelog element working properly");
                driver.findElement(By.xpath("/html/body/div[1]/div[1]/a")).click();
                driver.findElement(By.xpath("/html/body/nav[2]/a[3]")).click();
                System.out.println("My learning working properly");
                driver.findElement(By.xpath("/html/body/div[1]/div[1]/a")).click();
                driver.findElement(By.xpath("/html/body/nav[2]/a[4]")).click();
                System.out.println("profile element working properly");
                driver.findElement(By.xpath("/html/body/div[1]/div[1]/a")).click();
                driver.findElement(By.xpath("/html/body/nav[2]/a[5]")).click();
                System.out.println("My subscription working properly");
                //Thread.sleep(3000);
                driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/a[2]")).click();
                //Thread.sleep(3000);
                driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/a[2]")).click();
                System.out.println("Signed out successfully");
                //Thread.sleep(3000);
                driver.close();
                System.out.println("Test Case: Successfull");
            }
        }
    }

}
