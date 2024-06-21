package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_17_ShadowDom {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TC_01_Shadow_Dom() {
        driver.get("https://automationfc.github.io/shadow-dom/");

        WebElement hostElement = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext rootElement1 = hostElement.getShadowRoot();

        String testText = rootElement1.findElement(By.cssSelector("span#shadow_content>span")).getText();
        System.out.println("Đoạn text cần tìm là: " + testText);
        Assert.assertEquals(testText, "some text");

        WebElement rootElement2 = rootElement1.findElement(By.cssSelector("input[type = 'checkbox']"));
        if(rootElement2.isSelected()){
            System.out.println("Checked!");
        } else {
            System.out.println("Unchecked");
        }

        Assert.assertFalse(rootElement2.isSelected());



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