package bbc.pages;

import bbc.helpers.SeleniumHelper;
import bbc.tests.BaseBBCTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HomePage extends BaseBBCTest {


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
        this.driver = driver;
    }


    public void checkDate() {
        String textFromHeader = driver.findElement(By.xpath("//section[@class= 'module module--header']/h2")).getText();
        String[] lines = textFromHeader.split("\\n");
        String dateFromPage = lines[1];
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, dd LLLL");
        String actualDate = dtf.format(currentDateTime);

        Assert.assertEquals(dateFromPage, actualDate, "Date on page is incorrect");
    }
}
