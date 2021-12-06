import org.testng.Assert;
import org.testng.annotations.Test;
import page.TrivagoFlightsPage;
import page.TrivagoHomePage;
import util.CommonConditions;

public class TrivagoFlightsPageSearchFormTest extends CommonConditions {
    private static final String LOCATION_FROM = "";
    private static final String LOCATION_TO = "";
    private static final String TRIP_TYPE = "Multi-city";
    private static final int MAX_NUMBER_OF_FORMS = 6;

    @Test
    public void emptyFromAndToFieldsFlightsPageTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);
        TrivagoFlightsPage flightsPage = homePage.openFlightsPage();

        flightsPage.searchFlights();

        Assert.assertTrue(flightsPage.isLocationExceptionVisible());
    }

    @Test
    public void sameFromAndToFieldsFlightsPageTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);
        TrivagoFlightsPage flightsPage = homePage.openFlightsPage();

        final String[] locations = flightsPage.enterFromLocation(LOCATION_FROM)
                                              .enterToLocation(LOCATION_TO)
                                              .getFromAndToLocations();

        final String[] changedLocations = flightsPage.swapLocations()
                                                     .getFromAndToLocations();

        Assert.assertTrue(locations[0].equals(changedLocations[1]) && locations[1].equals(changedLocations[0]));
    }

    @Test
    public void maxNumberOfFlightFormsFlightsPageTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);
        TrivagoFlightsPage flightsPage = homePage.openFlightsPage();

        final int maxNumberOfForms = flightsPage.changeTripType(TRIP_TYPE)
                                                .addMaxNumberOfFlightForm()
                                                .getNumberOfFlightForms();

        Assert.assertEquals(MAX_NUMBER_OF_FORMS, maxNumberOfForms);
    }
}
