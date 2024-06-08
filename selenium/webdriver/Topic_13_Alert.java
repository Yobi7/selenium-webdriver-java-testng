package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_13_Alert {
    WebDriver driver;
    WebDriverWait explicitWait;

    By resultText = By.cssSelector("p#result");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Accept_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text() = 'Click for JS Alert']")).click();
        sleepInSeconds(3);

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Alert");

        alert.accept();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(resultText).getText(),"You clicked an alert successfully");

    }

    @Test
    public void TC_02_Accept_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text() = 'Click for JS Alert']")).click();

        // wait alert present
        // Trong thoi gian cho ma xuat hien => tu switch
        // Het thoi gian wait chua xuat hien => fail
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        sleepInSeconds(3);

        Assert.assertEquals(alert.getText(),"I am a JS Alert");

        alert.accept();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(resultText).getText(),"You clicked an alert successfully");

    }

    @Test
    public void TC_03_Confirm_Alert() {

    }

    @Test
    public void TC_04_Pompt_Alert() {

    }

    @Test
    public void TC_05_Authenticate_Alert() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmailAddress(){
        Random rand = new Random();
        return "kevinlamp" + rand.nextInt(99999) + "@gmail.net";
    }
}