package bbc.pages;

import bbc.helpers.SeleniumHelper;
import bbc.tests.BaseBBCTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SearchPage extends BaseBBCTest {


    @FindBy(id = "search-input")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitSearchButton;

    @FindBy(xpath = "//span[text() = 'next page']/../../..")
    private WebElement nextPageButton;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
        this.driver = driver;
    }

    public void setSearchInput(String searchValue) {
        helper.waitForElementToBeDisplayed(searchInput, 5);
        searchInput.sendKeys(searchValue);
        helper.waitForElementToBeDisplayed(submitSearchButton,5);
        submitSearchButton.click();
    }

    public void verifySearchResult() {
        helper.waitForElementToBeDisplayed(By.xpath("//ol/li"),5);
        List<WebElement> pageSelectButtonsList = driver.findElements(By.xpath("//ol/li"));
        int pageSelectButtonsListCount = pageSelectButtonsList.size();
        // The test passes if the program finds no results. Test doesn't include external database.
        if (pageSelectButtonsListCount == 0) {
            return;
        }
        // takes the last button and retrieves its text to repeat the loop the appropriate number of times. Beyond 13 pages in the search list, not all buttons are visible.
        int lastPageValue = Integer.parseInt(pageSelectButtonsList.get(pageSelectButtonsListCount - 1).getText());

        for (int p = 1; p <= lastPageValue; p++) {
            int numberOfArticlesOnPage = driver.findElements(By.xpath("//ul[@class='ssrcss-1020bd1-Stack e1y4nx260']/li")).size();

            for (int i = 0; i < numberOfArticlesOnPage; i++) {
                List<WebElement> articlesOnPage = driver.findElements(By.xpath("//ul[@class='ssrcss-1020bd1-Stack e1y4nx260']/li"));
                helper.waitForElementToBeDisplayed(articlesOnPage.get(i), 10);
                articlesOnPage.get(i).click();
                try {
                    //checks if the page contains expected words
                    helper.waitForElementToBeDisplayed(By.xpath("//*[contains(text(), 'Houghton') or contains(text(), 'Mifflin') or contains(text(), 'Harcourt')]"),5);
                } catch (TimeoutException exception) {
                    System.out.println(exception.getMessage());
                    Assert.fail("Article does not contain the searched content");
                }
                driver.navigate().back();
            }
            helper.waitForElementToBeDisplayed(nextPageButton, 5);
            nextPageButton.click();
        }
    }
}
