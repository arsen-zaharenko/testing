package page;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrivagoCarsResultsPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private By currencyLocator = By.xpath("//div[@class='EuxN-Current']");

    private By locationLocator = By.xpath("");

    protected TrivagoCarsResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized(String location, String currency) {
        if (location.equals(1))
        LOGGER.log(Level.INFO, "Location and currency are true");
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
