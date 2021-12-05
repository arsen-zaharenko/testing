import org.testng.Assert;
import org.testng.annotations.Test;
import page.TrivagoCarsPage;
import page.TrivagoFlightsPage;
import page.TrivagoHomePage;
import util.CommonConditions;

public class TrivagoCarsPageSearchFormTest extends CommonConditions {
    private static final String LOCATION_EXCEPTION_TEXT = "Please pick a pick-up location.";

    @Test
    public void emptyFromFieldCarsPageTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);

        TrivagoCarsPage carsPage = homePage.openCarsPage()
                .findCars();

        final String locationExceptionText = carsPage.getLocationExceptionText();

        Assert.assertEquals(LOCATION_EXCEPTION_TEXT, locationExceptionText);
    }

    @Test
    public void findCarsForUkrainianHryvniasTest() {

    }
}
