package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_07_WebElement_Commands_02 {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if(driver.findElement(By.cssSelector("input#mail")).isDisplayed()){
            driver.findElement(By.cssSelector("input#mail")).sendKeys("Automation Testing");
            System.out.println("Email Textbox is displayed");
        } else {
            System.out.println("Email Textbox is NOT displayed");
        }

        if(driver.findElement(By.cssSelector("input#under_18")).isDisplayed()){
            driver.findElement(By.cssSelector("input#under_18")).click();
            System.out.println("under_18 is displayed");
        } else {
            System.out.println("under_18 is NOT displayed");
        }

        if(driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()){
            driver.findElement(By.cssSelector("textarea#edu")).sendKeys("Automation Testing");
            System.out.println("Edu is displayed");
        } else {
            System.out.println("Edu is NOT displayed");
        }

        if(driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()){
            System.out.println("User5  is displayed");
        } else {
            System.out.println("User5 is NOT displayed");
        }


        Assert.assertFalse(driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed());


    }

    @Test
    public void TC_02_Enabled() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if(driver.findElement(By.cssSelector("input#mail")).isEnabled()){
            System.out.println("Email is enabled");
        } else {
            System.out.println("Email is disabled");
        }


        if(driver.findElement(By.cssSelector("input#disable_password")).isEnabled()){
            System.out.println("Password is enabled");
        } else {
            System.out.println("Password is disabled");
        }

    }

    @Test
    public void TC_03_Selected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");


        driver.findElement(By.cssSelector("input#under_18")).click();
        driver.findElement(By.cssSelector("input#java")).click();

        if(driver.findElement(By.cssSelector("input#under_18")).isSelected()){
            System.out.println("Element is selected");
        } else {
            System.out.println("Element is de-selected");
        }

        if(driver.findElement(By.cssSelector("input#java")).isSelected()){
            System.out.println("Element is selected");
        } else {
            System.out.println("Element is de-selected");
        }


        driver.findElement(By.cssSelector("input#java")).click();
        if(driver.findElement(By.cssSelector("input#under_18")).isSelected()){
            System.out.println("Element is selected");
        } else {
            System.out.println("Element is de-selected");
        }

        if(driver.findElement(By.cssSelector("input#java")).isSelected()){
            System.out.println("Element is selected");
        } else {
            System.out.println("Element is de-selected");
        }



    }
    @Test
    public void TC_04_MailChimp() {


    }


    @AfterClass
    public void afterClass() {
    }

    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
