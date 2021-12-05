package page;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrivagoCarsPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private By carsFrame = By.xpath("//iframe[contains(@class,kayak)]");

    private By currencyPickerButtonLocator = By.xpath("//div[contains(@class,'currency-picker')]");

    private By locationDivLocator = By.xpath("//div[@class='d_E3']/div");

    private By locationInputLocator = By.xpath("//input[@placeholder='From?']");

    private By searchButtonLocator = By.xpath("//button[@title='Search cars']");

    private By locationExceptionLocator = By.className("IGR4-error");

    public TrivagoCarsPage(WebDriver driver) {
        super(driver);
        LOGGER.log(Level.INFO, "Cars page is opened");
        driver.switchTo().frame(findElementByLocator(carsFrame));
    }

    public TrivagoCarsPage changeCurrency(String currency) {
        findElementByLocatorAndClick(currencyPickerButtonLocator);
        findElementByLocatorAndClick(By.xpath("//div[contains(@class,'currency-tooltip-symbol')" +
                                              " and (text()='" + currency + "')]"));
        LOGGER.log(Level.INFO, "Currency is changed by [{}]", currency);
        return this;
    }

    public TrivagoCarsPage enterLocation(String location) {
        findElementByLocatorAndClick(locationDivLocator);
        findElementByLocatorAndClick(locationInputLocator).sendKeys(location);
        findElementByLocatorAndClick(By.xpath("//li[contains(@aria-label,'" + location + "')]"));
        LOGGER.log(Level.INFO, "Location [{}] is entered", location);
        return this;
    }

    public TrivagoCarsResultsPage searchCars() {
        findElementByLocatorAndClick(searchButtonLocator);
        return new TrivagoCarsResultsPage(driver);
    }

    public String getLocationExceptionText() {
        return findElementByLocatorAndGetText(locationExceptionLocator);
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
