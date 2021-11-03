package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrivagoHomePage {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://www.trivago.com/";

    private By destinationInputLocator = By.xpath("//div[@class='relative h-11 flex items-stretch overflow-hidden 2xl:rounded-sm']/input");

    private By roomFormLocator = By.xpath("//div[@class='SearchFormFlyout_roomSelector__3rks1']/button");

    private By roomFormDivLocator = By.xpath("//div[@class='pt-4 px-2']");

    private By numberOfAdultsInputLocator = By.xpath("//input[@id='number-input-13']");

    private By searchButtonLocator = By.xpath("//div[@class='SearchFormFlyout_searchButtonWrapperSingleLine__3Ivc5']");

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

    public TrivagoHomePage fillAdultsField(int numberOfAdults) {
        findElementByLocatorAndClickStaleElementReferenceException(numberOfAdultsInputLocator)
                .sendKeys(Keys.DELETE + String.valueOf(numberOfAdults));
        findElementByLocatorAndClickStaleElementReferenceException(roomFormDivLocator);
        return this;
    }

    public TrivagoResultsPage searchHotels() {
        findElementByLocatorAndClickStaleElementReferenceException(searchButtonLocator);
        return new TrivagoResultsPage(driver);
    }

    private WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, 20)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
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
}
