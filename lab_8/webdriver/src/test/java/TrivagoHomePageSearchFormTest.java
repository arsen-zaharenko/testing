import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.TrivagoHomePage;
import page.TrivagoResultsPage;

public class TrivagoHomePageSearchFormTest {
    private WebDriver driver;
    private FirefoxOptions options = new FirefoxOptions().setHeadless(true);

    private static final String DESTINATION = "Minsk";
    private static final String DESTINATION_EXCEPTION_TEXT = "To start, tell us where you're going";
    private static final String BIG_GROUP_HINT_TEXT = "Big group? Try Hotelplanner.com for 6+ rooms";
    private static final int NUMBER_OF_ADULTS = 4;
    private static final int BIG_NUMBER_OF_ADULTS = 99;
    private static final int MAX_NUMBER_OF_ADULTS = 48;

    private By destinationExceptionLocator = By.xpath("(//*[contains(text(),\"To start, tell us where you're going\")])[2]");

    private By roomFormApplyButtonLocator = By.xpath("//button[@data-role='applyConfigBtn']");

    private WebElement numberOfAdultsSpan;
    private By numberOfAdultsSpanLocator = By.xpath("//span[@class='dealform-button__label']");

    @Test
    public void emptyDestinationFieldTest() {
        driver = new FirefoxDriver(options);
        driver.manage().window().setSize(new Dimension(1000, 1000));
        
        TrivagoHomePage homePage = new TrivagoHomePage(driver);
        homePage.openHomePage()
                .searchHotels();

        final String destinationExceptionText = homePage.getTextStaleElementReferenceException(destinationExceptionLocator);

        Assert.assertEquals(DESTINATION_EXCEPTION_TEXT, destinationExceptionText);
    }
    
    @Test
    public void bigGroupHintTest() {
        driver = new FirefoxDriver(options);
        driver.manage().window().setSize(new Dimension(1000, 1000));
        
        TrivagoHomePage homePage = new TrivagoHomePage(driver);
        
        final String bigGroupHintText = homePage.openHomePage()
                                                .openRoomForm()
                                                .fillAdultsField(BIG_NUMBER_OF_ADULTS)
                                                .getBigGroupHintText();

        Assert.assertEquals(BIG_GROUP_HINT_TEXT, bigGroupHintText);
    }
    
    @Test
    public void maxNumberOfAdultsTest() {
        driver = new FirefoxDriver(options);
        driver.manage().window().setSize(new Dimension(1000, 1000));
        
        TrivagoHomePage homePage = new TrivagoHomePage(driver);
        homePage.openHomePage()
                .openRoomForm()
                .fillAdultsField(BIG_NUMBER_OF_ADULTS);

        homePage.findElementByLocatorAndClickStaleElementReferenceException(roomFormApplyButtonLocator);

        numberOfAdultsSpan = homePage.findElementByLocatorStaleElementReferenceException(numberOfAdultsSpanLocator);

        final int maxNumberOfAdults = Integer
                .parseInt(homePage.getTextStaleElementReferenceException(numberOfAdultsSpanLocator)
                        .replace("Guests","")
                        .trim());

        Assert.assertEquals(MAX_NUMBER_OF_ADULTS, maxNumberOfAdults);
    }
    
    @Test
    public void findHotelsTest() {
        driver = new FirefoxDriver(options);
        driver.manage().window().setSize(new Dimension(1000, 1000));
        
        TrivagoHomePage homePage = new TrivagoHomePage(driver);
        TrivagoResultsPage resultsPage = homePage.openHomePage()
                                                 .enterDestination(DESTINATION)
                                                 .openRoomForm()
                                                 .fillAdultsField(NUMBER_OF_ADULTS)
                                                 .searchHotels();

        Assert.assertTrue(resultsPage.isInitialized());
    }
}
