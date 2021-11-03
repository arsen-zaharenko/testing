package page;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrivagoResultsPage {
    private WebDriver driver;

    private By accommodationListLocator = By.xpath("//ol[@id='js_itemlist']");

    public TrivagoResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isInitialized() {
        return findElementByLocatorStaleElementReferenceException(accommodationListLocator).isDisplayed();
    }

    private WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, 60)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }

    private WebElement findElementByLocatorStaleElementReferenceException(By locator) {
        try {
            return findElementByLocator(locator);
        } catch (StaleElementReferenceException e) {
            return findElementByLocator(locator);
        }
    }
}
