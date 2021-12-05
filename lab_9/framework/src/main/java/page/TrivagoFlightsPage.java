package page;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrivagoFlightsPage extends AbstractPage{
    private By flightsFrame = By.xpath("//iframe[contains(@class,kayak)]");

    private By searchButtonLocator = By.xpath("//div[@class='search-form-inner']/div/div[2]");

    private By formExceptionLocator = By.xpath("//ul[@class='errorMessages']");

    public TrivagoFlightsPage(WebDriver driver) {
        super(driver);
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

    private WebElement defaultFindElementByLocator(By locator) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }

    public WebElement findElementByLocator(By locator) {
        try {
            return defaultFindElementByLocator(locator);
        } catch (StaleElementReferenceException e) {
            return defaultFindElementByLocator(locator);
        }
    }

    public WebElement findElementByLocatorAndClick(By locator) {
        try {
            WebElement element = defaultFindElementByLocator(locator);
            element.click();
            return element;
        } catch (StaleElementReferenceException e) {
            WebElement element = defaultFindElementByLocator(locator);
            element.click();
            return element;
        }
    }

    public String findElementByLocatorAndGetText(By locator) {
        try {
            return findElementByLocator(locator).getText();
        } catch (StaleElementReferenceException e) {
            return findElementByLocator(locator).getText();
        }
    }
}
