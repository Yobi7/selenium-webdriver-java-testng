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
import java.util.List;
import java.util.Random;

public class Topic_12_Checkbox_Radio {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Default_Telerik_Checkbox() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        sleepInSeconds(3);

        By rearSideCheckbox = By.xpath("//label[text()='Rear side airbags']/preceding-sibling::span/input");
        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");

        //Case 1: App checkbox dđã chọn trước or chuưa chọn
        checkToElement(rearSideCheckbox);
        checkToElement(dualZoneCheckbox);

        // Verify checkbox đã được chn thành conông
        Assert.assertTrue(driver.findElement(rearSideCheckbox).isSelected());
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());

        // Bỏ chọn checkbox
        unCheckToElement(rearSideCheckbox);
        unCheckToElement(dualZoneCheckbox);

        Assert.assertFalse(driver.findElement(rearSideCheckbox).isSelected());
        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());

    }

    @Test
    public void TC_02_Default_Telerik_Radio() {
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");

        By twoPetrol = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");
        By twoDiesel = By.xpath("//label[text()='2.0 Diesel, 103kW']/preceding-sibling::span/input");

        // Click chọn 1 trong 2
        checkToElement(twoPetrol);

        // Verify
        Assert.assertTrue(driver.findElement(twoPetrol).isSelected());
        Assert.assertFalse(driver.findElement(twoDiesel).isSelected());

        checkToElement(twoDiesel);
    }

    @Test
    public void TC_04_Select_All_Checkbox() {
        driver.get("https://automationfc.github.io/multiple-fields/");

        List<WebElement> allCheckbox = driver.findElements(By.cssSelector("input.form-checkbox"));

        // Chon ALL checkbox tren màn hình
        for(WebElement checkbox : allCheckbox){
            if (!checkbox.isSelected()){
                checkbox.click();
            }
        }

        // Verify All checkbox
        for(WebElement checkbox : allCheckbox){
            Assert.assertTrue(checkbox.isSelected());
        }

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        allCheckbox = driver.findElements(By.cssSelector("input.form-checkbox"));

        // Choọn 1
        for(WebElement checkbox : allCheckbox){
            if (checkbox.getAttribute("Value").equals("Heart Attack") && !checkbox.isSelected()){
                checkbox.click();
                sleepInSeconds(1);
            }
        }

        // Verify all checkbox
        for(WebElement checkbox : allCheckbox){
            if (checkbox.getAttribute("Value").equals("Heart Attack")){
                Assert.assertTrue(checkbox.isSelected());
            } else {
                Assert.assertFalse(checkbox.isSelected());
            }
        }

    }
    @Test
    public void TC_05_Custom_Checkbox(){

    }





    @AfterClass
    public void afterClass() {driver.quit();
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

    public void checkToElement(By byXpath){
        if(!driver.findElement(byXpath).isSelected()){
            driver.findElement(byXpath).click();
            sleepInSeconds(2);
        }
    }

    public void unCheckToElement(By byXpath){
        if(driver.findElement(byXpath).isSelected()){
            driver.findElement(byXpath).click();
            sleepInSeconds(2);
        }
    }
}