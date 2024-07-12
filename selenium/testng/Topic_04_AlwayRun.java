package testng;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_04_AlwayRun {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("Run before class");

//        //Giả s bị false ở đây
//        Assert.assertTrue(false);
    }

    @Test
    public void TC_01_() {
        System.out.println("Run testcase 01");
    }
    @Test
    public void TC_02_() {
        //Giả s bị false ở đây
        Assert.assertTrue(false);

        System.out.println("Run testcase 02");
    }

    @Test
    public void TC_03_() {
        System.out.println("Run testcase 03");
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
        System.out.println("Run after class");
    }


}
