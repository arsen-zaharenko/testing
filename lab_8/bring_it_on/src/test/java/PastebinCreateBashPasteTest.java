import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PastebinCreatePasteResultsPage;
import page.PastebinHomePage;

public class PastebinCreateBashPasteTest {
    private WebDriver driver;
    private static final String CODE = "git config --global user.name  \"New Sheriff in Town\"\n" +
                                       "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                       "git push origin master --force";
    private static final String NAME = "how to gain dominance among developers";
    private static final String PAGE_HEADER = NAME;
    private static final String SYNTAX = "Bash";

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
        driver.manage().window().setSize(new Dimension(1000, 2000));
    }

    @Test
    public void pageHeaderCompareTest() {
        PastebinHomePage homePage = new PastebinHomePage(driver);
        final String pageHeader = homePage.openHomePage()
                                          .pasteCode(CODE)
                                          .selectSyntaxHighlighting()
                                          .selectExpiration()
                                          .pasteName(NAME)
                                          .createPaste()
                                          .copyPageHeader();
        Assert.assertEquals(pageHeader, PAGE_HEADER);
    }

    @Test
    public void checkSyntaxHighlightingTest() {
        PastebinHomePage homePage = new PastebinHomePage(driver);
        final boolean isHighlighting = homePage.openHomePage()
                                               .pasteCode(CODE)
                                               .selectSyntaxHighlighting()
                                               .selectExpiration()
                                               .pasteName(NAME)
                                               .createPaste()
                                               .isHighlighting(SYNTAX);
        Assert.assertTrue(isHighlighting);
    }

    @Test
    public void checkCodeTest() {
        PastebinHomePage homePage = new PastebinHomePage(driver);
        final boolean isEquals = homePage.openHomePage()
                                         .pasteCode(CODE)
                                         .selectSyntaxHighlighting()
                                         .selectExpiration()
                                         .pasteName(NAME)
                                         .createPaste()
                                         .isEquals(CODE);
        Assert.assertTrue(isEquals);
    }

    @Test
    public void createBashPasteTest() {
        PastebinHomePage homePage = new PastebinHomePage(driver);
        PastebinCreatePasteResultsPage resultsPage = homePage.openHomePage()
                                                             .pasteCode(CODE)
                                                             .selectSyntaxHighlighting()
                                                             .selectExpiration()
                                                             .pasteName(NAME)
                                                             .createPaste();
        Assert.assertTrue(resultsPage.isInitialized());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        driver = null;
    }
}
