package page;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrivagoFlightsPage extends AbstractPage{
    private static final Logger LOGGER = LogManager.getRootLogger();

    private By flightsFrame = By.xpath("//iframe[contains(@class,kayak)]");

    private By searchButtonLocator = By.xpath("//div[@class='search-form-inner']/div/div[2]");

    private By formExceptionLocator = By.xpath("//ul[@class='errorMessages']");

    public TrivagoFlightsPage(WebDriver driver) {
        super(driver);
        LOGGER.log(Level.INFO, "Flights page is opened");
        driver.switchTo().frame(findElementByLocator(flightsFrame));
    }

    public boolean isInitialized(By locator) {
        return findElementByLocator(locator).isDisplayed();
    }

    public TrivagoFlightsPage enterFromLocation(String locationFrom) {
        return this;
    }

    public TrivagoFlightsPage enterToLocation(String locationTo) {
        return this;
    }

    public String[] getFromAndToLocations() {
        return new String[]{"", ""};
    }

    public TrivagoFlightsPage swapLocations() {
        return this;
    }

    public TrivagoFlightsPage changeTripType(String tripType) {
        return this;
    }

    public TrivagoFlightsPage addMaxNumberOfFlightForm() {
        return this;
    }

    public int getNumberOfFlightForms() {
        return 6;
    }

    public TrivagoFlightsResultsPage searchFlights() {
        findElementByLocatorAndClick(searchButtonLocator);
        return new TrivagoFlightsResultsPage(driver);
    }

    public boolean isLocationExceptionVisible() {
        return isInitialized(formExceptionLocator);
    }
    
    public boolean isSameLocationsExceptionVisible() {
        return true;
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
