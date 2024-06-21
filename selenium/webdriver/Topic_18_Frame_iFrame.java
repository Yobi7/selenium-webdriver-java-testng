package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_18_Frame_iFrame {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_() {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        driver.findElement(By.cssSelector("div#imageTemplateContainer>img")).click();
        sleepInSeconds(15);

        WebElement formiFrame = driver.findElement(By.cssSelector("div#formTemplateContainer>iframe"));

        driver.switchTo().frame(formiFrame);

        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Junior");

        sleepInSeconds(3);



    }


    @Test
    public void TC_03_() {

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