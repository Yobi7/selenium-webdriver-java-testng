package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_22_Wait_Element_Status {
    WebDriver driver;
    WebDriverWait explicitWait;

    By reconfirmEmailTextbox = By.cssSelector("input[name = 'reg_email_confirmation__']");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01_Visible() {
        driver.findElement(By.cssSelector("a[data-testid = 'open-registration-form-button']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input[name = 'reg_email__']")).sendKeys("sakura@gmail.com");
        sleepInSeconds(2);

        // Tại đúng thời điểm này - step: Confirm Email texbox đang visible/displayed
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(reconfirmEmailTextbox));

        // KIểm tra 1 element đang hiển thị
        Assert.assertTrue(driver.findElement(reconfirmEmailTextbox).isDisplayed());
    }

    @Test
    public void TC_02_Invisible_In_DOM() {
        driver.findElement(By.cssSelector("a[data-testid = 'open-registration-form-button']")).click();
        sleepInSeconds(5);

        // Đk 2: Element không xuất hiện UI, vẫn có trong cây HTML
        driver.findElement(By.cssSelector("input[name = 'reg_email__']")).clear();
        sleepInSeconds(2);

        // Tại đúng thời điểm này - step: Confirm Email texbox không visible/displayed
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reconfirmEmailTextbox));

        // KIểm tra 1 element đang không hiển thị
        Assert.assertFalse(driver.findElement(reconfirmEmailTextbox).isDisplayed());

    }

    @Test
    public void TC_03_Invisible_Not_In_DOM() {
        //Face cũng không ổn định
        driver.findElement(By.cssSelector("a[data-testid = 'open-registration-form-button']")).click();
        sleepInSeconds(5);

        // Đk 3: Element k0 xuất hiện UI cũng không có trong cây HTML
        driver.findElement(By.xpath("//div[text() = 'Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInSeconds(2);

        // Tại đúng thời điểm này - step: Confirm Email texbox không visible/displayed
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reconfirmEmailTextbox));

        // KIểm tra 1 element đang không hiển thị
        //Assert.assertFalse(driver.findElement(reconfirmEmailTextbox).isDisplayed());

    }

    @Test
    public void TC_04_Presence() {
        driver.findElement(By.cssSelector("a[data-testid = 'open-registration-form-button']")).click();
        sleepInSeconds(5);

        driver.findElement(By.cssSelector("input[name = 'reg_email__']")).sendKeys("sakura@gmail.com");
        sleepInSeconds(2);

        // Dk1: UI hiện - DOM hiện
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(reconfirmEmailTextbox));

        // Dk2: UI không hiện - DOM hiện
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(reconfirmEmailTextbox));

    }

    @Test
    public void TC_05_Staleness() {
        driver.findElement(By.cssSelector("a[data-testid = 'open-registration-form-button']")).click();
        sleepInSeconds(5);

        WebElement reconfirmEmail = driver.findElement(reconfirmEmailTextbox);

        driver.findElement(By.xpath("//div[text() = 'Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInSeconds(2);

        //Wait until an element is no longer attached to the DOM.
        explicitWait.until(ExpectedConditions.stalenessOf(reconfirmEmail));

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