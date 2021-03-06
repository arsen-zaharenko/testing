package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrivagoHomePage {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://www.trivago.com/";

    private By destinationInputLocator = By.xpath("//input[@id='querytext']");

    private By roomFormLocator = By.xpath("//button[@class='dealform-button dealform-button--guests js-dealform-button-guests']");

    private WebElement roomFormDiv;
    private By roomFormDivLocator = By.xpath("//div[@class='guest-selector__content clearfix']");

    private By bigGroupHintLocator = By.xpath("//div[@class='guest-selector__content clearfix']/a");
    
    private By numberOfAdultsInputLocator = By.xpath("//input[@class='input room-filters__input']");

    private By searchButtonLocator = By.xpath("//span[text()='Search']");

    public TrivagoHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public TrivagoHomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public TrivagoHomePage enterDestination(String destination) {
        findElementByLocatorAndClickStaleElementReferenceException(destinationInputLocator)
                .sendKeys(destination);
        return this;
    }

    public TrivagoHomePage openRoomForm() {
        findElementByLocatorAndClickStaleElementReferenceException(roomFormLocator);
        return this;
    }

    public String getBigGroupHintText() {
        return getTextStaleElementReferenceException(bigGroupHintLocator);
    }
    
    public TrivagoHomePage fillAdultsField(int numberOfAdults) {
        findElementByLocatorAndClickStaleElementReferenceException(numberOfAdultsInputLocator)
                .sendKeys(Keys.BACK_SPACE + String.valueOf(numberOfAdults));
        roomFormDiv = findElementByLocatorAndClickStaleElementReferenceException(roomFormDivLocator);
        return this;
    }

    public TrivagoResultsPage searchHotels() {
        findElementByLocatorAndClickStaleElementReferenceException(searchButtonLocator);
        return new TrivagoResultsPage(driver);
    }

    public WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, 20)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }

    public WebElement findElementByLocatorStaleElementReferenceException(By locator) {
        try {
            return findElementByLocator(locator);
        } catch (StaleElementReferenceException e) {
            return findElementByLocator(locator);
        }
    }
    
    public WebElement findElementByLocatorAndClickStaleElementReferenceException(By locator) {
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
    
    public String getTextStaleElementReferenceException(By locator) {
        try {
            return findElementByLocatorStaleElementReferenceException(locator).getText();
        } catch (StaleElementReferenceException e) {
            return findElementByLocatorStaleElementReferenceException(locator).getText();
        }
    }
}
