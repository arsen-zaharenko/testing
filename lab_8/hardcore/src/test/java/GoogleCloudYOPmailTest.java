import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.GoogleCloudHomePage;
import page.YOPmailGeneratePage;
import page.YOPmailHomePage;

import java.util.Set;

public class GoogleCloudYOPmailTest {
    private WebDriver driver;
    private final static String TERM = "Google Cloud Platform Pricing Calculator";
    private final static int NUMBER_OF_INSTANCES = 4;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
        driver.manage().window().setSize(new Dimension(1000, 2000));
    }

    @Test
    void compareCostTest() {
        YOPmailHomePage YOPmailPage = new YOPmailHomePage(driver);
        GoogleCloudHomePage GoogleCloudPage = new GoogleCloudHomePage(driver);

        String YOPmailTab = driver.getWindowHandle();
        String GoogleCloudTab = "";
        YOPmailGeneratePage generatePage = YOPmailPage.openHomePage()
                                                      .generateEmail();
        final String email = generatePage.copyEmail();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()", "");

        Set<String> tabs = driver.getWindowHandles();
        for (String tab: tabs) {
            if (!tab.equals(YOPmailTab)) {
                GoogleCloudTab = tab;
                break;
            }
        }

        driver.switchTo().window(GoogleCloudTab);
        final String instancesCost = GoogleCloudPage.openHomePage()
                .searchTerm(TERM)
                .openCalculator()
                .pasteNumberOfInstances(NUMBER_OF_INSTANCES)
                .selectSeries()
                .selectMachineType()
                .addGPUs()
                .addSSD()
                .selectDatacenter()
                .selectCommittedUsage()
                .addToEstimate()
                .emailEstimate(email)
                .copyCost();

        Assert.assertTrue(YOPmailPage.openHomePage()
                                     .openEmail(email)
                                     .compareCost(instancesCost));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        driver = null;
    }
}