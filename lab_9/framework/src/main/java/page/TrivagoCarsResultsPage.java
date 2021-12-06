package page;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrivagoCarsResultsPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    protected TrivagoCarsResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized(String location, String currency) {
        LOGGER.log(Level.INFO, driver.getCurrentUrl());
        LOGGER.log(Level.INFO, driver.getPageSource());
        /*
        By currencyLocator = By.xpath("//div[@class='EuxN-Current']");
        By locationLocator = By.xpath("//div[@class='NbWx-locationInput']/div/div/div[2]");
        
        if (findElementByLocatorAndGetText(locationLocator).contains(location)
            && findElementByLocatorAndGetText(currencyLocator).contains(currency)) {
            LOGGER.log(Level.INFO, "Location and currency are true");
            return true;
        }

        LOGGER.log(Level.ERROR, "Invalid location or currency");
*/
        return false;
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
