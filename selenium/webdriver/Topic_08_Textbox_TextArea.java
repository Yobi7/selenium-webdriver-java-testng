package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_08_Textbox_TextArea {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void Login_01_Empty_Email_And_Password() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class = 'footer'] //a[@title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(),"This is a required field.");


    }
    @Test
    public void Login_02_Invalid_Email() {


    }

    @Test
    public void Login_03_Password() {


    }

    @Test
    public void Login_04_Incorrect_Email_Password() {


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
