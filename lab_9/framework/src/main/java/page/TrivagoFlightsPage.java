package page;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public TrivagoFlightsPage findFlights() {
        findElementByLocatorAndClick(searchButtonLocator);
        return this;
    }

    public boolean isLocationExceptionVisible() {
        return isInitialized(formExceptionLocator);
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
