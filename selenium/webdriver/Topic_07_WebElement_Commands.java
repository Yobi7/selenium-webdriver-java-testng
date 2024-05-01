package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_07_WebElement_Commands {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {


        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01_Element() {
        // Dùng xóa ...
        driver.findElement(By.id("email")).clear();

        // Dùng nhap du lieu
        driver.findElement(By.id("email")).sendKeys("yoyo@gmail.com");

        // Click element
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // tim tu node cha vao note con
        /*driver.findElement(By.id("form-validate")).findElement(By.id("firstname"));
        driver.findElement(By.cssSelector("form#form-validate input#firstname"));*/

        // Tra ve 1-n element khớp voi dieu kien
        WebElement fullNameTextbox = driver.findElement(By.id(""));
        List<WebElement> textboxes = driver.findElements(By.id(""));

        //Verify 1 checkbox/radio/dropdown da duoc chon hay chua
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());

        //dropdown (default/custom)
        Select select = new Select(driver.findElement(By.id("")));

        //Verify 1 element co hien thi hay khong? (
        Assert.assertTrue(driver.findElement(By.id("")).isDisplayed());

        //Verify 1 element co duoc thao tac hay khong? (not read-only)
        Assert.assertTrue(driver.findElement(By.id("")).isEnabled());

        // HTML Element
        driver.findElement(By.id("")).getAttribute("title");

        // Tab Accesibility / Properties trong Element
        driver.findElement(By.id("")).getAccessibleName();
        driver.findElement(By.id("")).getDomAttribute("checked");

        //Tab Styles (GUI)
        // Font/ Size/ Color/ BG...
        driver.findElement(By.id("")).getCssValue("font-size");

        // Vi tri cua Element so voi do phan giai man hinh
        Point nameTextboxLocation = driver.findElement(By.id("")).getLocation();
        nameTextboxLocation.getX();
        nameTextboxLocation.getY();

        // Chieu rong + cao
        Dimension addressSize = driver.findElement(By.id("")).getSize();

        // Location + Size
        Rectangle nameTextboxRect = driver.findElement(By.id("")).getRect();

        // Location
        Point namePoint = nameTextboxRect.getPoint();

        // Size
        Dimension nameSize = nameTextboxRect.getDimension();
        nameSize.getHeight();
        nameSize.getWidth();

        //Shadow element (JavascriptExecutor)
        driver.findElement(By.id("")).getShadowRoot();

        // Tu id/class/name/css/zpath truy nguoc lai tagname HTML
        driver.findElement(By.id("firstname")).getTagName();

        // Text
        driver.findElement(By.cssSelector("address.copyright")).getText();

        // Chup hinh bi loi va luu lai: BYTE, FILE, BASE64
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.FILE);

        // Form (element nao la the form hoac na mtrong the form) - giong phim Enter
        driver.findElement(By.id("")).submit();








    }


    @AfterClass
    public void afterClass() { }


}
