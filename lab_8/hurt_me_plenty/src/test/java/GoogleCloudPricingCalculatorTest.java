import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleCloudPricingCalculatorTest {
    private WebDriver driver;
    private final static String TERM = "Google Cloud Platform Pricing Calculator";
    private final static int NUMBER_OF_INSTANCES = 4;
    private final static String VM_CLASS = "regular";
    private final static String INSTANCE_TYPE = "n1-standard-8";
    private final static String REGION = "Frankfurt";
    private final static String LOCAL_SSD = "2x375 GiB";
    private final static String COMMITMENT_TERM = "1 Year";
    private final static String INSTANCES_COST = "1,085.25";

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
        driver.manage().window().setSize(new Dimension(1000, 2000));
    }

    @Test
    void VMClassCompareTest() {
        GoogleCloudHomePage GoogleCloudPage = new GoogleCloudHomePage(driver);

        final String VMClass = GoogleCloudPage.openHomePage()
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
                                                    .copyVMClass();
        Assert.assertEquals(VMClass, VM_CLASS);
    }

    @Test
    void instanceTypeCompareTest() {
        GoogleCloudHomePage GoogleCloudPage = new GoogleCloudHomePage(driver);

        final String instanceType = GoogleCloudPage.openHomePage()
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
                                                  .copyInstanceType();
        Assert.assertEquals(instanceType, INSTANCE_TYPE);
    }

    @Test
    void regionCompareTest() {
        GoogleCloudHomePage GoogleCloudPage = new GoogleCloudHomePage(driver);

        final String region = GoogleCloudPage.openHomePage()
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
                                             .copyRegion();
        Assert.assertEquals(region, REGION);
    }

    @Test
    void localSSDCompareTest() {
        GoogleCloudHomePage GoogleCloudPage = new GoogleCloudHomePage(driver);

        final String localSSD = GoogleCloudPage.openHomePage()
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
                                               .copyLocalSSD();
        Assert.assertEquals(localSSD, LOCAL_SSD);
    }

    @Test
    void commitmentTermCompareTest() {
        GoogleCloudHomePage GoogleCloudPage = new GoogleCloudHomePage(driver);

        final String commitmentTerm = GoogleCloudPage.openHomePage()
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
                                                     .copyCommitmentTerm();
        Assert.assertEquals(commitmentTerm, COMMITMENT_TERM);
    }

    @Test
    void costCompareTest() {
        GoogleCloudHomePage GoogleCloudPage = new GoogleCloudHomePage(driver);

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
                                                    .copyCost();
        Assert.assertEquals(instancesCost, INSTANCES_COST);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        driver = null;
    }
}