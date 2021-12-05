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

public class TrivagoStaysResultsPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private By accommodationListLocator = By.xpath("//ol[@id='js_itemlist']");

    public TrivagoStaysResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        LOGGER.log(Level.INFO, "Stays are found");
        return findElementByLocator(accommodationListLocator).isDisplayed();
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
