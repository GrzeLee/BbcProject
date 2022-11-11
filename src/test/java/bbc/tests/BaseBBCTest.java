package bbc.tests;

import bbc.helpers.DriverFactory;
import bbc.helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class BaseBBCTest {

    protected WebDriver driver;
    protected SeleniumHelper helper;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.com/");
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
        DriverFactory.resetDriver();
    }

}
