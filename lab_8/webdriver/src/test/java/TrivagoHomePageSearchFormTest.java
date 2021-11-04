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

    private static final String DESTINATION = "Minsk";
    private static final String DESTINATION_EXCEPTION_TEXT = "To start, tell us where you're going";
    private static final String BIG_GROUP_HINT_TEXT = "Big group? Try Hotelplanner.com for 6+ rooms";
    private static final int NUMBER_OF_ADULTS = 4;
    private static final int BIG_NUMBER_OF_ADULTS = 99;
    private static final int MAX_NUMBER_OF_ADULTS = 48;

    private WebElement destinationException;
    private By destinationExceptionLocator = By.xpath("(//*[contains(text(),\"To start, tell us where you're going\")])[2]");

    private By roomFormApplyButtonLocator = By.xpath("//button[@data-role='applyConfigBtn']");

    private WebElement numberOfAdultsSpan;
    private By numberOfAdultsSpanLocator = By.xpath("//span[@class='dealform-button__label']");

    @BeforeTest
    setupBrowser();

    @Test
    public void emptyDestinationFieldTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);
        homePage.openHomePage()
                .searchHotels();

        destinationException = findElementByLocatorStaleElementReferenceException(destinationExceptionLocator);

        final String destinationExceptionText = getTextStaleElementReferenceException(destinationException, destinationExceptionLocator);

        Assert.assertEquals(DESTINATION_EXCEPTION_TEXT, destinationExceptionText);
    }
    
    @BeforeTest
    setupBrowser();
    
    @Test
    public void bigGroupHintTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);
        
        final String bigGroupHintText = homePage.openHomePage()
                                                .openRoomForm()
                                                .fillAdultsField(BIG_NUMBER_OF_ADULTS)
                                                .getBigGroupHintText();

        Assert.assertEquals(BIG_GROUP_HINT_TEXT, bigGroupHintText);
    }
    
    @BeforeTest
    setupBrowser();
    
    @Test
    public void maxNumberOfAdultsTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);
        homePage.openHomePage()
                .openRoomForm()
                .fillAdultsField(BIG_NUMBER_OF_ADULTS);

        findElementByLocatorAndClickStaleElementReferenceException(roomFormApplyButtonLocator);

        numberOfAdultsSpan = findElementByLocatorStaleElementReferenceException(numberOfAdultsSpanLocator);

        final int maxNumberOfAdults = Integer
                .parseInt(getTextStaleElementReferenceException(numberOfAdultsSpan, numberOfAdultsSpanLocator)
                        .replace("Guests","")
                        .trim());

        Assert.assertEquals(MAX_NUMBER_OF_ADULTS, maxNumberOfAdults);
    }
    
    @BeforeTest
    setupBrowser();
    
    @Test
    public void findHotelsTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);
        TrivagoResultsPage resultsPage = homePage.openHomePage()
                                                 .enterDestination(DESTINATION)
                                                 .openRoomForm()
                                                 .fillAdultsField(NUMBER_OF_ADULTS)
                                                 .searchHotels();

        Assert.assertTrue(resultsPage.isInitialized());
    }

    private void setupBrowser() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
        driver.manage().window().setSize(new Dimension(1000, 1000));
    }
    
    private WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, 60)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }

    private WebElement findElementByLocatorStaleElementReferenceException(By locator) {
        try {
            return findElementByLocator(locator);
        } catch (StaleElementReferenceException e) {
            return findElementByLocator(locator);
        }
    }

    private WebElement findElementByLocatorAndClickStaleElementReferenceException(By locator) {
        try {
            WebElement element = findElementByLocator(locator);
            element.click();
            return element;
        } catch (StaleElementReferenceException e) {
            WebElement element = findElementByLocator(locator);
            element.click();
            return element;
        }
    }

    private String getTextStaleElementReferenceException(WebElement element, By locator) {
        try {
            return element.getText();
        } catch (StaleElementReferenceException e) {
            element = findElementByLocatorStaleElementReferenceException(locator);
            return element.getText();
        }
    }
}
