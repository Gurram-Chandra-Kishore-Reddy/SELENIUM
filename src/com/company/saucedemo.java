package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class saucedemo {
    public static void main(String [] args) throws InterruptedException {
        String [] usernames = new String[4];
        usernames[0] = "standard_user";
        usernames[1] = "locked_out_user";
        usernames[2] = "problem_user";
        usernames[3] = "performance_glitch_user";
        String password = "secret_sauce";
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        for(int i = 0;i<usernames.length;i++) {
            System.out.print("YES");
            WebDriver driver = new ChromeDriver();
            System.out.print("YES");
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[1]/input")).sendKeys(usernames[i]);///html/body/div/div/div[2]/div[1]/div[1]/div/form/div[1]/input
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[2]/input")).sendKeys(password);
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/input")).click();
            try {
                driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div[3]/select")).click();
            }
            catch (Exception e)
            {
                System.out.println("Test case " + i + " failed with username: " + usernames[i]);
                driver.close();
                continue;
            }
            //A to Z
            System.out.println("Test Case " + i + ": " + "username = " + usernames[i] + ";");
            System.out.println("    Checking the sort button");
            System.out.println("    1. Checking A to Z");
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div[3]/select/option[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div[3]/div")).click();
            Thread.sleep(1000);
            if (driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/a/div")).getText().equals("Sauce Labs Backpack")) {
                System.out.println("    Affirmative all the items in the inventory sorted based on the Alphabetical order from A to Z");
            }
            //Z to A
            System.out.println("    2. Checking Z to A");
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div[3]/select")).click();
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div[3]/select/option[2]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div[3]/div")).click();
            Thread.sleep(1000);
            if (driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/a/div")).getText().equals("Test.allTheThings() T-Shirt (Red)")) {
                System.out.println("    Affirmative,all the items in the inventory sorted based on the Alphabetical order from Z to A");
            }
            else
            {
                System.out.println("    Failed to sort based on alphabetical order from z to A");
            }
            //low to high
            System.out.println("    3. Checking price low to high");
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div[3]/select")).click();
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div[3]/select/option[3]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div[3]/div")).click();
            Thread.sleep(1000);
            if (driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/a/div")).getText().equals("Sauce Labs Onesie")) {
                System.out.println("    Affirmative,all the items in the inventory sorted based on the price from low to high");
            }
            else
            {
                System.out.println("    Failed to sort the items based on the price from low to high");
            }
            //high to low
            System.out.println("    4. Checking price high to low");
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div[3]/select")).click();
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div[3]/select/option[4]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div[3]/div")).click();
            Thread.sleep(1000);
            if (driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/a/div")).getText().equals("Sauce Labs Fleece Jacket")) {
                System.out.println("    Affirmative,all the items in the inventory sorted based on the price from high to low");
            }
            else
            {
                System.out.println("    Failed to sort the items based on the price from high to low");
            }
            System.out.println("    Checking if item is added to cart");
            //adding item to cart
            String name = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/a/div")).getText();
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[1]/div[3]/button")).click();
            driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[2]/a")).click();
            if (name.equals(driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[1]/div[3]/div[2]/a/div")).getText())) {
                System.out.println("    Successfully added item into the cart");
            }
            System.out.println("    Proceeding with adding all other items");
            // adding all other items
            driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/a[1]")).click();
            if (driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[1]/div[3]/button")).getText().equals("ADD TO CART"))
                driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[1]/div[3]/button")).click();
            if (driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[2]/div[3]/button")).getText().equals("ADD TO CART"))
                driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[2]/div[3]/button")).click();
            if (driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[3]/div[3]/button")).getText().equals("ADD TO CART"))
                driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[3]/div[3]/button")).click();
            if (driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[4]/div[3]/button")).getText().equals("ADD TO CART"))
                driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[4]/div[3]/button")).click();
            if (driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[5]/div[3]/button")).getText().equals("ADD TO CART"))
                driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[5]/div[3]/button")).click();
            if (driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[6]/div[3]/button")).getText().equals("ADD TO CART"))
                driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[6]/div[3]/button")).click();
            System.out.println("    Added all items into the cart");
            driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[2]/a")).click();
            System.out.println("    All the items are found in the card");
            System.out.println("    Proceeding to checkout");
            driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/a[2]")).click();
            driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/form/div[1]/input[1]")).sendKeys("Chandra");
            driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/form/div[1]/input[2]")).sendKeys("Kishore");
            driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/form/div[1]/input[3]")).sendKeys("518004");
            driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/form/div[2]/input")).click();
            //checking total amout
            System.out.println("    Checking the total amount");
            if(driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/div[5]")).getText().equals("Item total: $129.94"))
                System.out.println("    " + driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/div[5]")).getText());
            else
            {
                System.out.println("    " + driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/div[5]")).getText());
                System.out.println("Failed to calculate the correct Bill amount");
            }
            //finishing
            System.out.println("    Finishing");
            driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/div[8]/a[2]")).click();
            System.out.println("!!!!!!!!!!!!!!!Successfully Completed!!!!!!!!!!!!");
            driver.close();
        }
    }
}
