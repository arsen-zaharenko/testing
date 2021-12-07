package page;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TrivagoFlightsPage extends AbstractPage{
    private static final Logger LOGGER = LogManager.getRootLogger();

    private By flightsFrame = By.xpath("//iframe[contains(@class,kayak)]");

    private By dateDivLocator = By.xpath("//div[text()='Depart']");

    private By departDateDivLocator = By.xpath("//div[contains(@aria-label,'Depart') and (text()='Depart')]");

    private By returnDateDivLocator = By.xpath("//div[contains(@id,'return-input')]");

    private By removeButtonLocator = By.xpath("//button[contains(@class,'remove')]");

    private By locationTextLocator = By.xpath("//div[contains(@class,'js-selection-display')]");

    private By fromLocationDivLocator = By.xpath("//div[text()='From?']");

    private By fromLocationIputLocator = By.xpath("//input[contains(@id,'origin-airport')]");

    private By toLocationDivLocator = By.xpath("//div[text()='To?']");

    private By toLocationInputLocator = By.xpath("//input[@placeholder='To?']");

    private By swapButtonLocator = By.xpath("//div[contains(@title,'Swap')]");

    private By tripTypeDivLocator = By.xpath("//div[text()='Round-trip']");

    private By addFlightFormButton = By.xpath("//span[text()='Add another flight']");

    private By flightFormDivLocator = By.xpath("//div[contains(@class,'multiCity')]");

    private By searchButtonLocator = By.xpath("//div[@class='search-form-inner']/div/div[2]");

    private By formExceptionLocator = By.xpath("//ul[@class='errorMessages']");

    private By sameLocationsExceptionLocator = By.xpath("//li[contains(text(),'unique')]");

    public TrivagoFlightsPage(WebDriver driver) {
        super(driver);
        LOGGER.log(Level.INFO, "Flights page is opened");
        driver.switchTo().frame(findElementByLocator(flightsFrame));
    }

    public boolean isInitialized(By locator) {
        return findElementByLocator(locator).isDisplayed();
    }

    public TrivagoFlightsPage enterDate(String departDate, String returnDate) {
        findElementByLocatorAndClick(dateDivLocator);
        findElementByLocatorAndClick(departDateDivLocator).sendKeys(departDate);
        LOGGER.log(Level.INFO, "Depart date [{}] is entered", departDate);
        findElementByLocatorAndClick(returnDateDivLocator).sendKeys(returnDate);
        LOGGER.log(Level.INFO, "Return date [{}] is entered", returnDate);
        findElementByLocatorAndClick(By.tagName("h1"));
        return this;
    }

    public TrivagoFlightsPage enterFromLocation(String fromLocation) {
        findElementByLocatorAndClick(removeButtonLocator);
        findElementByLocatorAndClick(fromLocationIputLocator).sendKeys(fromLocation);
        findElementByLocatorAndClick(By.xpath("//div[contains(text(),'" + fromLocation + "')][2]"));
        findElementByLocatorAndClick(By.tagName("h1"));
        LOGGER.log(Level.INFO, "From location [{}] is entered", fromLocation);
        return this;
    }

    public TrivagoFlightsPage enterToLocation(String toLocation) {
        findElementByLocatorAndClick(toLocationDivLocator);
        findElementByLocatorAndClick(toLocationInputLocator).sendKeys(toLocation);
        findElementByLocatorAndClick(By.xpath("//div[contains(text(),'" + toLocation + "')][2]"));
        findElementByLocatorAndClick(By.tagName("h1"));
        LOGGER.log(Level.INFO, "To location [{}] is entered", toLocation);
        return this;
    }

    public TrivagoFlightsPage enterSameLocations(String sameLocation) {
        enterFromLocation(sameLocation);
        swapLocations();
        findElementByLocatorAndClick(fromLocationDivLocator);
        findElementByLocatorAndClick(fromLocationIputLocator).sendKeys(sameLocation);
        findElementByLocatorAndClick(By.xpath("//div[contains(text(),'" + sameLocation + "')][2]"));
        findElementByLocatorAndClick(By.tagName("h1"));
        LOGGER.log(Level.INFO, "Same from location [{}] is entered", sameLocation);
        return this;
    }

    public String[] getFromAndToLocations() {
        final List<WebElement> locations = driver.findElements(locationTextLocator);
        final String fromLocation = locations.get(0).getText();
        final String toLocation = locations.get(1).getText();
        LOGGER.log(Level.INFO, "From location [{}] and to location [{}] are received", fromLocation, toLocation);
        return new String[]{fromLocation, toLocation};
    }

    public TrivagoFlightsPage swapLocations() {
        findElementByLocatorAndClick(swapButtonLocator);
        LOGGER.log(Level.INFO, "Locations are swapped");
        return this;
    }

    public TrivagoFlightsPage changeTripType(String tripType) {
        findElementByLocatorAndClick(tripTypeDivLocator);
        driver.findElement(By.xpath("//li[@data-title='"+ tripType+ "']")).click();
        LOGGER.log(Level.INFO, "Trip type is changed by [{}]", tripType);
        return this;
    }

    public TrivagoFlightsPage addMaxNumberOfFlightForm() {
        while (findElementByLocator(addFlightFormButton).isDisplayed()) {
            findElementByLocatorAndClick(addFlightFormButton);
        }
        LOGGER.log(Level.INFO, "Adding flight forms...");
        return this;
    }

    public int getNumberOfFlightForms() {
        final int numberOfFlightForms = driver.findElements(flightFormDivLocator).size();
        LOGGER.log(Level.INFO, "Number of flight forms equals [{}]", numberOfFlightForms);
        return numberOfFlightForms;
    }

    public TrivagoFlightsResultsPage searchFlights() {
        findElementByLocatorAndClick(searchButtonLocator);
        LOGGER.log(Level.INFO, "Searching...");
        return new TrivagoFlightsResultsPage(driver);
    }

    public boolean isLocationExceptionVisible() {
        return isInitialized(formExceptionLocator);
    }

    public boolean isSameLocationsExceptionVisible() {
        return isInitialized(sameLocationsExceptionLocator);
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
