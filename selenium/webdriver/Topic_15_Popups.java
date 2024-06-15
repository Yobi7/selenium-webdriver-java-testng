package webdriver;

import org.openqa.selenium.By;
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

public class Topic_15_Popups {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_FixedPopup_InDOM() {
        driver.get("https://ngoaingu24h.vn/");

        driver.findElement(By.cssSelector("button.login_")).click();
        sleepInSeconds(2);

        By loginPopup = By.cssSelector("div[id = 'modal-login-v1']>div");
        //Kiểm tra Popuplogin đang hiển thị
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        driver.findElement(By.cssSelector("input#account-input")).sendKeys("automationfc");
        driver.findElement(By.cssSelector("input#password-input")).sendKeys("automationfc");
        driver.findElement(By.cssSelector("div[id = 'modal-login-v1'] button.btn-login-v1")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("div[id = 'modal-login-v1'] div.error-login-panel")).getText(), "Tài khoản không tồn tại!");

        driver.findElement(By.cssSelector("div[id = 'modal-login-v1'] button.close")).click();

        // Kiểm tra Login Popup khong hiển thị
        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());

    }

    @Test
    public void TC_02_FixedPopup_InDOM_02() {
        driver.get("https://skills.kynaenglish.vn/dang-nhap");

        //Kiểm rta login popup có hiển thị
        WebElement loginPopup = driver.findElement(By.cssSelector("div#k-popup-account-login div.modal-content"));
        Assert.assertTrue(loginPopup.isDisplayed());

        driver.findElement(By.cssSelector("input#user-login")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#btn-submit-login")).click();
        sleepInSeconds(2);
        
        Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message"))
                .getText(),"Sai tên đăng nhập hoặc mật khẩu");

    }

    @Test
    public void TC_03_FixedPopup_Not_InDOM() {
        driver.get("https://tiki.vn/");


        driver.findElement(By.cssSelector("div#VIP_BUNDLE img")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("div[data-view-id = 'header_header_account_container']")).click();
        sleepInSeconds(2);

        WebElement loginPopup = driver.findElement(By.cssSelector("div.ReactModal__Content"));
        Assert.assertTrue(loginPopup.isDisplayed());

        driver.findElement(By.xpath("//button[text()='Tiếp Tục']")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("span.error-mess")).getText(),"Số điện thoại không được để trống");

        driver.findElement(By.cssSelector("button.btn-close img")).click();
        sleepInSeconds(2);

        // Khi popup vị đóng lại th HTML không còn trong DOM nữa
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.findElements(By.cssSelector("div.ReactModal__Content")).size(),0);

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