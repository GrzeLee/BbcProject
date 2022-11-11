package bbc.pages;

import bbc.helpers.SeleniumHelper;
import bbc.tests.BaseBBCTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CommonPage extends BaseBBCTest {

    @FindBy(xpath = "//button[@aria-label='Consent']")
    private WebElement consentButton;

    @FindBy(id = "bbccookies-continue-button")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//nav[@class ='orbit-header-links international']/ul/li[@class='orb-nav-homedotcom']/a")
    private WebElement navigationButtonToHome;

    @FindBy(xpath = "//nav[@class ='orbit-header-links international']/ul/li[@class='orb-nav-newsdotcom']/a")
    private WebElement navigationButtonToNews;

    @FindBy(xpath = "//nav[@class ='orbit-header-links international']/ul/li[@class='orb-nav-sport']/a")
    private WebElement navigationButtonToSport;

    @FindBy(xpath = "//nav[@class ='orbit-header-links international']/ul/li[@class='orb-nav-reeldotcom']/a")
    private WebElement navigationButtonToReel;

    @FindBy(xpath = "//nav[@class ='orbit-header-links international']/ul/li[@class='orb-nav-worklife']/a")
    private WebElement navigationButtonToWorklife;

    @FindBy(xpath = "//nav[@class ='orbit-header-links international']/ul/li[@class='orb-nav-traveldotcom']/a")
    private WebElement navigationButtonToTravel;

    @FindBy(xpath = "//nav[@class ='orbit-header-links international']/ul/li[@class='orb-nav-future']/a")
    private WebElement navigationButtonToFuture;

    @FindBy(xpath = "//nav[@class ='orbit-header-links international']/ul/li[@class='orb-nav-culture']/a")
    private WebElement navigationButtonToCulture;

    @FindBy(xpath = "//nav[@class ='orbit-header-links international']/ul/li[@class='orb-nav-tv']/a")
    private WebElement navigationButtonToTV;

    @FindBy(xpath = "//nav[@class ='orbit-header-links international']/ul/li[@class='orb-nav-weather']/a")
    private WebElement navigationButtonToWeather;

    @FindBy(xpath = "//nav[@class ='orbit-header-links international']/ul/li[@class='orb-nav-sounds']/a")
    private WebElement navigationButtonToSounds;

    @FindBy(xpath = "//a[@id='orbit-search-button']")
    private WebElement searchButton;


    public CommonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
        this.driver = driver;
    }


    public void acceptAllCookies() {
        helper.waitForElementToBeDisplayed(consentButton, 20);
        consentButton.click();
        acceptCookiesButton.click();
    }

    public void navigateToSearchPage() {
        helper.waitForElementToBeDisplayed(searchButton, 5);
        searchButton.click();
    }

    public void navigateToNews() {
        navigationButtonToNews.click();
    }

    public void checkNavigationLinks() {
        Assert.assertEquals(navigationButtonToHome.getAttribute("href"), "https://www.bbc.com/", "Wrong navigation link in home button");
        Assert.assertEquals(navigationButtonToNews.getAttribute("href"), "https://www.bbc.com/news", "Wrong navigation link in news button");
        Assert.assertEquals(navigationButtonToSport.getAttribute("href"), "https://www.bbc.com/sport", "Wrong navigation link in sport button");
        Assert.assertEquals(navigationButtonToReel.getAttribute("href"), "https://www.bbc.com/reel", "Wrong navigation link in reel button");
        Assert.assertEquals(navigationButtonToWorklife.getAttribute("href"), "https://www.bbc.com/worklife", "Wrong navigation link in worklife button");
        Assert.assertEquals(navigationButtonToTravel.getAttribute("href"), "https://www.bbc.com/travel", "Wrong navigation link in travel button");
        Assert.assertEquals(navigationButtonToFuture.getAttribute("href"), "https://www.bbc.com/future", "Wrong navigation link in future button");
        Assert.assertEquals(navigationButtonToCulture.getAttribute("href"), "https://www.bbc.com/culture", "Wrong navigation link in culture button");
        Assert.assertEquals(navigationButtonToTV.getAttribute("href"), "https://www.bbc.co.uk/schedules/p00fzl9m", "Wrong navigation link in tv button");
        Assert.assertEquals(navigationButtonToWeather.getAttribute("href"), "https://www.bbc.com/weather", "Wrong navigation link in weather button");
        Assert.assertEquals(navigationButtonToSounds.getAttribute("href"), "https://www.bbc.co.uk/sounds", "Wrong navigation link in sounds button");
    }

}
