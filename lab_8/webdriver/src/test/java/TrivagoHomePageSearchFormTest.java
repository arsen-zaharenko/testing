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
    private By destinationExceptionLocator = By.xpath("(//*[contains(text(),\"To start, tell us where you're going\")])[1]");

    private WebElement bigGroupHint;
    private By bigGroupHintLocator = By.xpath("//a[@class='block text-m text-blue-700 hover:underline mb-4']");

    private By roomFormApplyButtonLocator = By.xpath("//button[@data-testid='guest-selector-apply']");

    private WebElement numberOfAdultsSpan;
    private By numberOfAdultsSpanLocator = By.xpath("//div[@class='SearchFormFlyout_roomSelector__3rks1']/button/span/span[2]/span[2]");

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
        driver.manage().window().setSize(new Dimension(1000, 1000));
    }

    @Test
    public void emptyDestinationFieldTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);
        homePage.openHomePage()
                .searchHotels();

        destinationException = findElementByLocatorStaleElementReferenceException(destinationExceptionLocator);

        final String destinationExceptionText = getTextStaleElementReferenceException(destinationException, destinationExceptionLocator);

        Assert.assertEquals(DESTINATION_EXCEPTION_TEXT, destinationExceptionText);
    }

    @Test
    public void bigGroupHintTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);
        homePage.openHomePage()
                .openRoomForm()
                .fillAdultsField(BIG_NUMBER_OF_ADULTS);

        bigGroupHint = findElementByLocatorStaleElementReferenceException(bigGroupHintLocator);

        final String bigGroupHintText = getTextStaleElementReferenceException(bigGroupHint, bigGroupHintLocator);

        Assert.assertEquals(BIG_GROUP_HINT_TEXT, bigGroupHintText);
    }

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

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        driver = null;
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

    public String getTextStaleElementReferenceException(WebElement element, By locator) {
        try {
            return element.getText();
        } catch (StaleElementReferenceException e) {
            element = findElementByLocatorStaleElementReferenceException(locator);
            return element.getText();
        }
    }
}
