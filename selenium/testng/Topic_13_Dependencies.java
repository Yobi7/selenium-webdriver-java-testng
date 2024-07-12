package testng;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;


@Listeners(listeners.ExtentReport.class)
public class Topic_13_Dependencies {


    @BeforeClass
    public void beforeClass() {

    }

    @Test
    public void TC_01_CreateNewUser() {
    }

    @Test(dependsOnMethods = "TC_01_CreateNewUser")
    public void TC_02_ViewAndSearchUser() {

    }

    @Test(dependsOnMethods = "TC_01_CreateNewUser")
    public void TC_03_UpdateUser() {
        Assert.assertTrue(false);

    }

    @Test(dependsOnMethods = "TC_03_UpdateUser")
    public void TC_04_MoveUserToOtherRole() {

    }

    @Test(dependsOnMethods = "TC_04_MoveUserToOtherRole")
    public void TC_05_DeleteExistingUser() {

    }

    @AfterClass
    public void afterClass() {    }


}
