package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_09_Default_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void TC_01_Register() {
        driver.findElement(By.cssSelector("a.ico-register")).click();

        driver.findElement(By.id("FirstName")).sendKeys("");
        driver.findElement(By.id("LastName")).sendKeys("");

        driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")).click();

        driver.findElement(By.id("Email")).sendKeys("");
        driver.findElement(By.id("Company")).sendKeys("");
        driver.findElement(By.id("Password")).sendKeys("");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("");


    }

    @Test
    public void TC_02_Login() {

    }

    @Test
    public void TC_03_Form() {

    }

    @AfterClass
    public void afterClass() {    }
}