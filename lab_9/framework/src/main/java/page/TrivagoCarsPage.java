package page;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrivagoCarsPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private static final String CARS_PAGE_URL = "https://www.trivago.ca/cars#/cars";
    
    private String fromLocation;
    
    private By carsFrame = By.xpath("//iframe[contains(@class,kayak)]");

    private By currencyPickerButtonLocator = By.xpath("//div[contains(@class,'currency-picker')]");

    private By locationDivLocator = By.xpath("//*[text()='From?']");

    private By locationInputLocator = By.xpath("//*[@placeholder='From?']");

    private By dateDivLocator = By.xpath("//span[contains(@class,'date')]");

    private By dateFromSpanLocator = By.xpath("//span[contains(@class,'from-date')]");

    private By dateToSpanLocator = By.xpath("//span[contains(@class,'to-date')]");

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
        if (findElementByLocator(locationDivLocator).isDisplayed()) {
            findElementByLocatorAndClick(locationDivLocator);
        } else {
            findElementByLocatorAndClick(locationDivLocator);
        }

        if (findElementByLocator(locationInputLocator).isDisplayed()) {
            findElementByLocatorAndClick(locationInputLocator).sendKeys(location);
        } else {
            findElementByLocatorAndClick(locationDivLocator);
            findElementByLocatorAndClick(locationInputLocator).sendKeys(location);
        }
        fromLocation = findElementByLocator(By.xpath("//li[contains(@aria-label,'" + location + "')]"))
                       .getAttribute("aria-label");
        findElementByLocatorAndClick(By.xpath("//li[contains(@aria-label,'" + location + "')]"));
        LOGGER.log(Level.INFO, "Location [{}] is entered", location);
        return this;
    }

    public TrivagoCarsResultsPage searchCarsByButton() {
        findElementByLocatorAndClick(searchButtonLocator);
        return new TrivagoCarsResultsPage(driver);
    }
    
    public TrivagoCarsResultsPage searchCarsByURL() {
        findElementByLocatorAndClick(dateDivLocator);
        final String[] dateFrom = findElementByLocatorAndGetText(dateFromSpanLocator).split("/");
        final String[] dateTo = findElementByLocatorAndGetText(dateToSpanLocator).split("/");
        
        findElementByLocatorAndClick(By.tagName("h1"));
        
        final String location = fromLocation.replaceAll(" ", "");

        driver.get(CARS_PAGE_URL + location + "-c9524" + "/" +
                   dateFrom[2] + "-" + dateFrom[1] + "-" + dateFrom[0] + "/" +
                   dateTo[2] + "-" + dateTo[1] + "-" + dateTo[0] + ";map");
        LOGGER.log(Level.INFO, "Searching...");
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
