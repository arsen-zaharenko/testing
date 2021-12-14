import model.Date;
import model.Location;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.TrivagoFlightsPage;
import page.TrivagoHomePage;
import service.DatesCreator;
import service.LocationsCreator;
import util.CommonConditions;

public class TrivagoFlightsPageSearchFormTest extends CommonConditions {
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
    public void swapFromAndToFieldsFlightsPageTest() {
        Location testLocations = LocationsCreator.locationsFromProperty();
        TrivagoHomePage homePage = new TrivagoHomePage(driver);
        TrivagoFlightsPage flightsPage = homePage.openFlightsPage();

        final String[] locations = flightsPage.enterFromLocation(testLocations.getFromLocation())
                                              .enterToLocation(testLocations.getToLocation())
                                              .getFromAndToLocations();

        final String[] changedLocations = flightsPage.swapLocations()
                                                     .getFromAndToLocations();

        Assert.assertTrue(locations[0].equals(changedLocations[1]) && locations[1].equals(changedLocations[0]));
    }

    @Test
    public void sameFromAndToFieldsFlightsPageTest() {
        Location testLocations = LocationsCreator.sameLocationsFromProperty();
        Date testDates = DatesCreator.datesFromProperty();
        TrivagoHomePage homePage = new TrivagoHomePage(driver);

        TrivagoFlightsPage flightsPage = homePage.openFlightsPage()
                                                 .enterDate(testDates.getDepartDate(), testDates.getReturnDate())
                                                 .enterSameLocations(testLocations.getFromLocation());

        flightsPage.searchFlights();

        Assert.assertTrue(flightsPage.isSameLocationsExceptionVisible());
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
