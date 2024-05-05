package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_06_Webbrowser_Commands {

    WebDriver driver;
    WebElement element;


    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver = new EdgeDriver();
        driver = new SafariDriver();

    //element & elements ảnh huưởng bởi implicitWait
        //30s chờ  ti element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @Test
    public void TC_01_() {
        //set trưc tiêp vao
        driver.get("https://www.facebook.com/");

        //Khai bao bien roi gan vao
        String homePageUrl = "https://www.facebook.com/";
        driver.get(homePageUrl);

        driver.close();
        driver.quit();

        WebElement emailaddressTextbox = driver.findElement(By.id("email"));

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        checkboxes.get(1).click();

        //Lay du lieu ra
        driver.getCurrentUrl();
        driver.getPageSource();
        driver.getTitle();
        driver.getWindowHandle();
        driver.getWindowHandles();
        
        



    }


    @AfterClass
    public void afterClass() {

        driver.quit();
    }


}
