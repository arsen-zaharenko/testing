import org.testng.Assert;
import org.testng.annotations.Test;
import page.TrivagoCarsPage;
import page.TrivagoCarsResultsPage;
import page.TrivagoHomePage;
import util.CommonConditions;

public class TrivagoCarsPageSearchFormTest extends CommonConditions {
    private static final String CURRENCY = "Br";
    private static final String LOCATION = "Minsk";
    private static final String LOCATION_EXCEPTION_TEXT = "Please pick a pick-up location.";

    @Test
    public void emptyFromFieldCarsPageTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);
        TrivagoCarsPage carsPage = homePage.openCarsPage();

        carsPage.searchCars();

        final String locationExceptionText = carsPage.getLocationExceptionText();

        Assert.assertEquals(LOCATION_EXCEPTION_TEXT, locationExceptionText);
    }

    @Test
    public void findCarsForBelarusianRublesTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);
        TrivagoCarsResultsPage resultsPage = homePage.openCarsPage()
                                                     .changeCurrency(CURRENCY)
                                                     .enterLocation(LOCATION)
                                                     .searchCars();

        Assert.assertTrue(resultsPage.isInitialized(LOCATION, CURRENCY));
    }
}
