package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_10_Custom_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
    }

    @Test
    public void TC_01_() {
        //Click vao 1 thẻ để nó  heết các item ben trong dropdown ra
        driver.findElement(By.cssSelector("span#number-button")).click();

        //      2.1 - ổ ra chứa heết data
        //      2.2 - Chi chứa 1 phaần
        //      3.1 - item can chon hien thi thì click vào
        //      3.2 - can scroll de chon item can chon
        //      4 - kiem tra text item = item can chọn

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