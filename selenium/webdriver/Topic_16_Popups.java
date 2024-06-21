package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_16_Popups {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Random_Popup() {
        driver.get("https://www.javacodegeeks.com/");


        By newsletterPopup = By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none'])");

        // Nếu hiển thị thì close nó đi
        // 1.element k0 có trong DOM - 2. element luôn có trong HTML/DOM
        if(driver.findElements(newsletterPopup).size()>0 && driver.findElements(newsletterPopup).get(0).isDisplayed()){
            System.out.println("Popup hiển thị.");
            driver.findElement(By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none']) a:not([class])")).click();
            sleepInSeconds(2);
        } else {
            System.out.println("Popup không hiển thị");
        }

        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile Testing Explained");
        driver.findElement(By.cssSelector("button#search-submit")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//a[text() = 'Agile Testing Explained']")).isDisplayed());



    }

    @Test
    public void TC_02_() {

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