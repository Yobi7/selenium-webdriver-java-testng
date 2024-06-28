package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Topic_23_Wait_Find_Element {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01_FindElement() {
//        case 1 - Element được tìm thấy chỉ có 1
//        Sẽ không cần chờ hết timeout
//        Tìm thấy và trả về 1 element
//        Qua step tiếp theo
//        System.out.println("Start step: " + getDateTimeNow());
//        driver.findElement(By.cssSelector("input#email"));
//        System.out.println("End step: " + getDateTimeNow());

//        case 2 - Element được tìm thấy nhưng có nhiều hơn 1
//        Sẽ không cần chờ hết timeout
//        Lấy element đầu tiên dù có cả n node
//        Qua step tiếp theo
//        System.out.println("Start step: " + getDateTimeNow());
//        WebElement findElement = driver.findElement(By.cssSelector("input[type = 'text'] , [type = 'password']  "));
//        findElement.sendKeys("Sakura");
//        System.out.println("End step: " + getDateTimeNow());

//        Case 3 - Element không được tìm thấy
//        Chờ hết timeout 10s
//        Trong thời gian 10s này cứ mỗi nửa s sẽ tìm lại 1 lần
//        Nếu tìm lại mà thấy thì cũng trả về element rồi qua step tiếp theo
//        Nếu tìm lại mà ko thấy thì đánh fail testcase và throw exception: NoSuchElementException
//        Các step còn lại không chạy nữa

    }

    @Test
    public void TC_02_FindElements() {
        List<WebElement> elementList;
        // Case 1 - Element tìm thấy chỉ có 1
        // K0 cần chờ hết time out
        // Trả về List Element chứa đúng 1 element
//        System.out.println("Start step: " + getDateTimeNow());
//        elementList = driver.findElements(By.cssSelector("input#email"));
//        System.out.println("List have: " + elementList.size());
//        System.out.println("End step: " + getDateTimeNow());

//        case 2 - Element được tìm thấy nhưng có nhiều hơn 1
//        Sẽ không cần chờ hết timeout
//        Trả về List Element chứa đúng 1 element
//        System.out.println("Start step: " + getDateTimeNow());
//        elementList = driver.findElements(By.cssSelector("input[type = 'text'] , [type = 'password']  "));
//        System.out.println("List have: " + elementList.size());
//        System.out.println("End step: " + getDateTimeNow());

//        case 3 - Element không được tìm thấy
//        Chờ hết timeout 10s
//        Mỗi nửa s tìm lại 1 laần - polling
//        Nếu trong thời gian tìm lại mà thấy element thì cũng trả về List
//        Nếu hết thời gian mà tmi2 k0 thấy thì tr về List rỗng (empty)
//        Không đánh fail testcase
        System.out.println("Start step: " + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input#abc"));
        System.out.println("List have: " + elementList.size());
        System.out.println("End step: " + getDateTimeNow());


    }

    @Test
    public void TC_03_() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public String getDateTimeNow(){
        Date date = new Date();
        return date.toString();
    }
}