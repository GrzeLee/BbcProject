package bbc.tests;

import bbc.pages.HomePage;
import bbc.pages.CommonPage;
import bbc.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BBCTests extends BaseBBCTest {


    // [TC1] -	Verify the top navigation links.
    @Test
    public void checkTopBarNavigation() {
        CommonPage commonPage = new CommonPage(driver);
        commonPage.acceptAllCookies();
        commonPage.checkNavigationLinks();
    }

    // [TC2] -	Navigate to the “News” section and verify url is correct.
    @Test
    public void checkNewsURL() {
        CommonPage commonPage = new CommonPage(driver);
        commonPage.acceptAllCookies();
        commonPage.navigateToNews();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.bbc.com/news", "Wrong news page URL");
    }


    // [TC3] -	Verify the day and date displayed on the page is correct
    @Test
    public void dateVerify() {
        CommonPage commonPage = new CommonPage(driver);
        HomePage homePage = new HomePage(driver);
        commonPage.acceptAllCookies();
        homePage.checkDate();
    }

    // [TC4] -	In the top navigation, perform a search for “Houghton Mifflin Harcourt” and verify the search results.
    @Test
    public void searchVerify() {
        CommonPage commonPage = new CommonPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        commonPage.acceptAllCookies();
        commonPage.navigateToSearchPage();
        searchPage.setSearchInput("Houghton Mifflin Harcourt");
        searchPage.verifySearchResult();
    }


}
