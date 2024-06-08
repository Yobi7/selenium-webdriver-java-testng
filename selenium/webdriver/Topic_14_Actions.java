package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_14_Actions {
    WebDriver driver;

    Actions actions;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Hover_Tooltip() {
        driver.get("https://automationfc.github.io/jquery-tooltip/");

        WebElement ageTexbox = driver.findElement(By.cssSelector("input#age"));

        actions.moveToElement(ageTexbox).perform();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText()
                ,"We ask for your age only for statistical purposes.");
    }

    @Test
    public void TC_02_Hover_Menu_Login() {
        driver.get("https://www.fahasa.com/");

        actions.moveToElement(driver.findElement(
                By.xpath("//a[text()='Kids' and @class='desktop-main']"))).perform();

        sleepInSeconds(3);

        actions.click(driver.findElement(
                By.xpath("//a[text()='Home & Bath' and @class='desktop-categoryName']"))).perform();

        sleepInSeconds(2);


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