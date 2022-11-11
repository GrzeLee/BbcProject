package bbc.tests;

import bbc.helpers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseBBCTest {

    protected WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = DriverFactory.getChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.com/");
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }

}
