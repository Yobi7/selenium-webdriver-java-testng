package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Random;

public class Topic_10_Custom_Dropdown {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @Test
    public void TC_01_JQuery() {
        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");

        driver.findElement(By.cssSelector("span#number-button")).click();

        selectItemInDropdown("span#number-button","ul#number-menu div","15" );
        sleepInSeconds(2);

        driver.navigate().refresh();

        selectItemInDropdown("span#number-button","ul#number-menu div","10" );
        selectItemInDropdown("span#speed-button","ul#speed-menu div","Fast" );


    }

    @Test
    public void TC_02_() {

    }

    @Test
    public void TC_03_() {
        
    }

    @AfterClass
    public void afterClass() {
        // driver.quit();
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

    public void selectItemInDropdown(String parentCss, String childItemCss, String itemTextExpected){
        driver.findElement(By.cssSelector(parentCss)).click(); //"span#number-button"

        // wait + tìm element
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss))); //"ul#number-menu div"
        for (WebElement item : allItems){
            if(item.getText().equals(itemTextExpected)){
                item.click();
                break;
            }
        }
    }

}
