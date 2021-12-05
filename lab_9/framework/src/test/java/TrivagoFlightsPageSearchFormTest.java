import org.testng.Assert;
import org.testng.annotations.Test;
import page.TrivagoFlightsPage;
import page.TrivagoHomePage;
import util.CommonConditions;

public class TrivagoFlightsPageSearchFormTest extends CommonConditions {
    @Test
    public void emptyFromAndToFieldsFlightsPageTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);

        TrivagoFlightsPage flightsPage = homePage.openFlightsPage()
                                                 .findFlights();

        Assert.assertTrue(flightsPage.isLocationExceptionVisible());
    }

    @Test
    public void sameFromAndToFieldsFlightsPageTest() {

    }

    @Test
    public void swapFromAndToFieldsFlightsPageTest() {

    }

    @Test
    public void maxNumberOfFlightFormsFlightsPageTest() {

    }
}
