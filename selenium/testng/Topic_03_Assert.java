package testng;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Topic_03_Assert {
    WebDriver driver;

    @Test
    public void Test01() {
        String fullName = "Automation FC" ;

        // Equals = kiểm tra 2 dữ liệu bằng nhau (Actual - Expected)
        Assert.assertEquals(fullName,"Automation FC","Actual fullname is not the same!");

        // True - False = Điều kiện nhận vào là boolean (isDisplayed/ isEnable/ isSelected/ isMultiple/ ...
        //Assert.assertTrue(isElementDisplayed(By.cssSelector("")));
        //Assert.assertTrue(isElementDisplayed(By.cssSelector("")),"Element is not displayed!");
    }

    private boolean isElementDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

}
