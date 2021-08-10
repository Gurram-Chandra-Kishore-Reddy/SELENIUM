package com.company;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.support.ui.Select;
public class optionstest {
    public static void main(String [] args)
    {
                System.setProperty("webdriver.chrome.driver", "F:\\corona semester\\software tools E\\final drivers\\chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                String url = " https://www.tutorialspoint.com/tutor_connect/index.php";
                driver.get(url);
                driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
                Select s = new Select(driver.findElement(By.xpath("//select[@name=’selType’]")));
                // getting the list of options in the dropdown with getOptions()
                List <WebElement> op = s.getOptions();
                int size = op.size();
                for(int i =0; i<size ; i++){
                    String options = op.get(i).getText();
                    System.out.println(options);
                }
                driver.quit();
            }
        }

