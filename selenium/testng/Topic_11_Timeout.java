package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_11_Timeout {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test(timeOut = 50000)
    public void Login_01_Empty_Email_And_Password() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class = 'footer'] //a[@title='My Account']")).click();

        // Register
        driver.findElement(By.xpath("//span[text() = 'Create an Account']")).click();

        String firstName = "Manual", lastName = "FC", emailAddress = getEmailAddress(), password = "123456789";
        String fullName = firstName + " " + lastName;

        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);
        driver.findElement(By.cssSelector("button[title = 'Register']")).click();


        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Thank you for registering with Main Website Store.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(),"Hello, " + fullName + "!");

        String contactInfo = driver.findElement(By.xpath("//h3[text() = 'Contact Information']/parent::div//following-sibling::div/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        // Logout
        driver.findElement(By.cssSelector("a.skip-account")).click();
        driver.findElement(By.cssSelector("a[title = 'Log Out']")).click();

        // Login
        driver.findElement(By.xpath("//div[@class = 'footer'] //a[@title='My Account']")).click();

        driver.findElement(By.cssSelector("input#email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#pass")).sendKeys(password);

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(),"Hello, " + fullName + "!");
        contactInfo = driver.findElement(By.xpath("//h3[text() = 'Contact Information']/parent::div//following-sibling::div/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        System.out.println("Email / paswrord: " + getEmailAddress() + " - " + password);

        // Logout
        driver.findElement(By.cssSelector("a.skip-account")).click();
        driver.findElement(By.cssSelector("a[title = 'Log Out']")).click();
    }



    @AfterClass
    public void afterClass() { driver.quit();    }

    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public  String getEmailAddress(){
        Random rand = new Random();
        return "automation" + rand.nextInt(99999)+"@gmail.net";

    }

}
