package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YOPmailHomePage {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://yopmail.com/";

    private WebElement emailGenerateLink;
    private By emailGenerateLinkLocator = By.xpath("//a[@href='email-generator']");

    private WebElement loginInput;
    private By loginInputLocator = By.id("login");

    public YOPmailHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isInitialized() {
        return emailGenerateLink.isDisplayed();
    }

    public YOPmailHomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        emailGenerateLink = findElementByLocator(emailGenerateLinkLocator);
        loginInput = findElementByLocator(loginInputLocator);
        return this;
    }

    public YOPmailGeneratePage generateEmail() {
        emailGenerateLink.click();
        return new YOPmailGeneratePage(driver);
    }

    public YOPmailEmailPage openEmail(String email) {
        loginInput.clear();
        loginInput.sendKeys(email + Keys.ENTER);
        return new YOPmailEmailPage(driver);
    }

    private WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }
}
