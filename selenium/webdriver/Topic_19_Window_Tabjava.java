package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

public class Topic_19_Window_Tabjava {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Tabs_WindowID() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        String parentWebID = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text() = 'GOOGLE']")).click();

        // SwitchTo google
        switchToWindowById(parentWebID);

        String subWebID = driver.getWindowHandle();
        driver.findElement(By.cssSelector("textarea[name = 'q']")).sendKeys("Sakura Kimonoto");
        sleepInSeconds(3);

        // Switch về trang auto
        switchToWindowById(subWebID);

    }

    @Test
    public void TC_02_Tabs_Window_Title() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        String parentID = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text() = 'GOOGLE']")).click();
        sleepInSeconds(3);

        // SwitchTo google
        switchToWindowByTitle("Google");
        driver.findElement(By.cssSelector("textarea[name = 'q']")).sendKeys("Sakura Kimonoto");

        // Switch về trang auto
        switchToWindowByTitle("Selenium WebDriver");
        driver.findElement(By.xpath("//a[text() = 'FACEBOOK']")).click();
        sleepInSeconds(3);

        // SwitchTo Facebook
        switchToWindowByTitle("Facebook – log in or sign up");
        driver.findElement(By.cssSelector("input#email")).sendKeys("SakuraKimonoto");
        sleepInSeconds(3);

        closeAllWindowWithoutParent(parentID);
        sleepInSeconds(3);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void switchToWindowById(String expectedID){
        Set<String> allID = driver.getWindowHandles();
        for(String id : allID){
            if (!id.equals(expectedID)){
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchToWindowByTitle(String expectedTitle){
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs){
            driver.switchTo().window(id);

            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)){
                break;
            }
        }

    }

    public void closeAllWindowWithoutParent(String parentID){
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs){
            if (!id.equals(parentID)){
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);

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