package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class Topic_14_Actions {
    WebDriver driver;

    JavascriptExecutor javascriptExecutor;

    Actions actions;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        javascriptExecutor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Hover_Tooltip() {
        driver.get("https://automationfc.github.io/jquery-tooltip/");

        WebElement ageTexbox = driver.findElement(By.cssSelector("input#age"));

        actions.moveToElement(ageTexbox).perform();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText()
                ,"We ask for your age only for statistical purposes.");
    }

    @Test
    public void TC_02_Hover_Menu_Login() {
        driver.get("https://www.fahasa.com/");

        actions.moveToElement(driver.findElement(
                By.xpath("//a[text()='Kids' and @class='desktop-main']"))).perform();

        sleepInSeconds(3);

        actions.click(driver.findElement(
                By.xpath("//a[text()='Home & Bath' and @class='desktop-categoryName']"))).perform();

        sleepInSeconds(2);


    }

    @Test
    public void TC_03_ClickAndHold() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allNumbers = driver.findElements(By.cssSelector("li.ui-state-default"));
        Assert.assertEquals(allNumbers.size(),20);

        actions.clickAndHold(allNumbers.get(0))
                .pause(2000)
                .moveToElement(allNumbers.get(14))
                .pause(2000)
                .release()
                .perform();
        sleepInSeconds(3);

        List<WebElement> allNumbersSelected = driver.findElements(By.cssSelector("li.ui-state-default.ui-selected"));
        Assert.assertEquals(allNumbersSelected.size(),12);

        String[] allNumberTextExpectedArray = {"1","2","3","5","6","7","9","10","11","13","14","15"};
        List<String> allNumberTextActual = new ArrayList<String>();

        for (WebElement element : allNumbersSelected){
            allNumberTextActual.add(element.getText());
        }

        List<String> allNumberTextExpected = Arrays.asList(allNumberTextExpectedArray);
        Assert.assertEquals(allNumberTextExpected,allNumberTextActual);

    }

    @Test
    public void TC_04_ClickAndHold(){
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allNumbers = driver.findElements(By.cssSelector("li.ui-state-default"));
        Assert.assertEquals(allNumbers.size(),20);

        actions.clickAndHold(allNumbers.get(0)).moveToElement(allNumbers.get(11)).release().perform();
        actions.keyDown(Keys.CONTROL).perform();
        actions.clickAndHold(allNumbers.get(12))
                .moveToElement(allNumbers.get(14))
                .release()
                .perform();
        sleepInSeconds(3);

        List<WebElement> allNumbersSelected = driver.findElements(By.cssSelector("li.ui-state-default.ui-selected"));
        Assert.assertEquals(allNumbersSelected.size(),15);
    }


    @Test
    public void TC_06_DoubleClick() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text() = 'Double click me']"));

        if (driver.toString().contains("firefox")){
            javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",doubleClickButton);
            sleepInSeconds(3);
        }

        actions.doubleClick(doubleClickButton).perform();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(),"Hello Automation Guys!");

    }

    @Test
    public void TC_07_RightClick() {
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-paste")).isDisplayed());

        actions.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
        sleepInSeconds(2);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-paste")).isDisplayed());


        actions.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
        sleepInSeconds(2);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-paste.context-menu-hover.context-menu-visible")).isDisplayed());

        actions.click(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
        sleepInSeconds(2);

        driver.switchTo().alert().accept();
        sleepInSeconds(2);

        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-paste")).isDisplayed());
    }


    @Test
    public void TC_08_DragDropHTML4() {
        driver.get("https://automationfc.github.io/kendo-drag-drop/");

        WebElement smallElement = driver.findElement(By.cssSelector("div#draggable"));
        WebElement bigElement = driver.findElement(By.cssSelector("div#droptarget"));

        actions.dragAndDrop(smallElement, bigElement).perform();
        sleepInSeconds(3);

        Assert.assertEquals(bigElement.getText(),"You did great!");

        Assert.assertEquals(Color.fromString(bigElement.getCssValue("background-color")).asHex().toLowerCase(),"#03a9f4");


    }


    @Test
    public void TC_08_DragDrop_xpath() {
        driver.get("https://automationfc.github.io/kendo-drag-drop/");


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