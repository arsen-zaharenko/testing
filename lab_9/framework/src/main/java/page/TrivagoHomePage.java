package page;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrivagoHomePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private static final String HOMEPAGE_URL = "https://www.trivago.ca";
    private static final String CARS_PAGE_URL = "https://www.trivago.ca/cars";
    private static final String FLIGHTS_PAGE_URL = "https://www.trivago.ca/flights";

    private By destinationInputLocator = By.xpath("//input[@id='querytext']");

    private By destinationExceptionLocator = By.xpath("//div[@class='dealform__error-message']");

    private By roomFormLocator = By.xpath("//button[contains(@class,'button-guests')]");

    private By roomFormDivLocator = By.xpath("//div[contains(@class,'guest-selector')]");

    private By bigGroupHintLocator = By.xpath("//a[@rel='nofollow noopener noreferrer']");
    
    private By numberOfAdultsInputLocator = By.xpath("//input[@id='adults-input']");

    private By roomFormApplyButtonLocator = By.xpath("//button[contains(@class,'apply-config')]");

    private By numberOfAdultsSpanLocator = By.xpath("//span[contains(text(),'Guests')]");

    private By searchButtonLocator = By.xpath("//span[text()='Search']");

    public TrivagoHomePage(WebDriver driver) {
        super(driver);
    }

    public TrivagoHomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        LOGGER.log(Level.INFO, "Home page is opened");
        return this;
    }

    public TrivagoCarsPage openCarsPage() {
        driver.get(CARS_PAGE_URL);
        return new TrivagoCarsPage(driver);
    }

    public TrivagoFlightsPage openFlightsPage() {
        driver.get(FLIGHTS_PAGE_URL);
        return new TrivagoFlightsPage(driver);
    }

    public TrivagoHomePage enterDestination(String destination) {
        findElementByLocatorAndClick(destinationInputLocator).sendKeys(destination);
        LOGGER.log(Level.INFO, "Destination [{}]  is entered", destination);
        return this;
    }

    public String getDestinationExceptionText() {
        LOGGER.log(Level.INFO, "Destination exception text is received");
        return findElementByLocatorAndGetText(destinationExceptionLocator);
    }

    public TrivagoHomePage openRoomForm() {
        findElementByLocatorAndClick(roomFormLocator);
        LOGGER.log(Level.INFO,"Room form is opened");
        return this;
    }

    public String getBigGroupHintText() {
        LOGGER.log(Level.INFO, "Big group hint text is received");
        return findElementByLocatorAndGetText(bigGroupHintLocator);
    }
    
    public TrivagoHomePage fillAdultsField(int numberOfAdults) {
        findElementByLocatorAndClick(numberOfAdultsInputLocator)
                .sendKeys(Keys.BACK_SPACE + String.valueOf(numberOfAdults));
        findElementByLocatorAndClick(roomFormDivLocator);
        LOGGER.log(Level.INFO, "Adults field is filled");
        return this;
    }

    public TrivagoHomePage clickRoomFormApplyButton() {
        findElementByLocatorAndClick(roomFormApplyButtonLocator);
        LOGGER.log(Level.INFO, "Apply button in the room form is clicked");
        return this;
    }

    public String getNumberOfAdults() {
        LOGGER.log(Level.INFO, "Number of adults is received");
        return findElementByLocatorAndGetText(numberOfAdultsSpanLocator).replace("Guests","")
                                                                        .trim();
    }

    public TrivagoStaysResultsPage searchHotels() {
        findElementByLocatorAndClick(searchButtonLocator);
        LOGGER.log(Level.INFO, "Searching...");
        return new TrivagoStaysResultsPage(driver);
    }

    @Override
    protected WebElement defaultFindElementByLocator(By locator) {
        return super.defaultFindElementByLocator(locator);
    }

    @Override
    protected WebElement findElementByLocator(By locator) {
        return super.findElementByLocator(locator);
    }

    @Override
    protected WebElement findElementByLocatorAndClick(By locator) {
        return super.findElementByLocatorAndClick(locator);
    }

    @Override
    protected String findElementByLocatorAndGetText(By locator) {
        return super.findElementByLocatorAndGetText(locator);
    }
}
