package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Scanner;

public class vit_test {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.setProperty("webdriver.chrome.driver","F:\\corona semester\\software tools E\\final drivers\\chromedriver.exe");
        System.out.println("Enter the semester");
        String sem = sc.nextLine();
        System.out.println("Enter the slot");
        String slotstring = sc.nextLine();
        System.out.println("Enter faculty name");
        String fac = sc.nextLine();
        System.out.println("Enter course name");
        String coursestr = sc.nextLine();
        WebDriver driver = new ChromeDriver();
        driver.get("https://vtop.vit.ac.in/vtop/");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[1]/div[3]/div/button")).click(); // student login
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div/div[2]/form/div[1]/input")).sendKeys("17MIS0066"); // username
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div/div[2]/form/div[2]/input")).sendKeys("password"); // password
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div/div[2]/form/div[3]/div[3]/button")).click(); // login
        driver.findElement(By.xpath("/html/body/div[1]/div/header/nav/div/div[1]/div/button")).click(); // three dots
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[1]/aside/div/div[2]/div/div/div[4]/div[1]/h4/a")).click(); // academics
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[1]/aside/div/div[2]/div/div/div[4]/div[2]/div/ul/li[12]/a")).click(); // course page
        // storing all dropdown in a list
        Select s = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[3]/div/div/section/div/div/div[2]/form/div[1]/div/select")));
        List<WebElement> op = s.getOptions();
        for(int i = 0;i<op.size();i++)
        {
            if(sem.equals(op.get(i).getText()))
            {
                driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[3]/div/div/section/div/div/div[2]/form/div[1]/div/select")).click();
                op.get(i).click();
                break;
            }
        }
        // selecting course
        Select c = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[3]/div/div/section/div/div/div[2]/form/div[2]/div/div/select")));
        List<WebElement> course = c.getOptions();
        Select f = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[3]/div/div/section/div/div/div[2]/form/div[4]/div/select")));
        List<WebElement> faculty = f.getOptions();
        Select slo = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[3]/div/div/section/div/div/div[2]/form/div[3]/div/select")));
        List<WebElement> slot = slo.getOptions();
        for(int i = 0;i<slot.size();i++)
        {
            if(slotstring.equals(slot.get(i).getText()))
            {
                driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[3]/div/div/section/div/div/div[2]/form/div[3]/div/select")).click();
                slot.get(i).click();
                break;
            }
        }
        for(int i = 0;i<faculty.size();i++)
        {
            if(fac.equals(faculty.get(i).getText()))
            {
                driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[3]/div/div/section/div/div/div[2]/form/div[4]/div/select"));
                faculty.get(i).click();
                break;
            }
        }
        for(int i = 0;i<course.size();i++)
        {
            if(coursestr.equals(course.get(i).getText()))
            {
                driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[3]/div/div/section/div/div/div[2]/form/div[2]/div/div/select"));
                course.get(i).click();
                break;
            }
        }
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[3]/div/div/div/section/div/div/div[2]/form/div[5]/div/table/tbody/tr[2]/td[9]/button")).click();
        // inside while loop
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[3]/div/div/div/section/div/div/div[2]/form/div[3]/div[2]/div/table/tbody/tr[2]/td[5]/p/a")).click();
        // logout
        driver.findElement(By.xpath("/html/body/div[1]/div/header/nav/div/div[2]/ul[1]/li/a/span/span[2]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/header/nav/div/div[2]/ul[1]/li/ul/li[3]/div/a")).click();
        driver.close();
    }
}
//code for table element extraction
//public void testTable() {
//
//    WebElement simpleTable = driver.findElement(By.id("items"));
//
//    //Get all rows
//    List<WebElement> rows = simpleTable.findElements(By.tagName("tr"));
//    assertEquals(3, rows.size());
//
//    //Print data from each row
//    for (WebElement row : rows) {
//        List<WebElement> cols = row.findElements(By.tagName("td"));
//        for (WebElement col : cols) {
//            System.out.print(col.getText() + "\t");
//        }
//        System.out.println();
//    }
//}
