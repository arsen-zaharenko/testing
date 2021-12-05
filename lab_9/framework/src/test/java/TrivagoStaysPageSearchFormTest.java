import org.testng.Assert;
import org.testng.annotations.Test;
import page.TrivagoHomePage;
import page.TrivagoStaysResultsPage;
import util.CommonConditions;

public class TrivagoStaysPageSearchFormTest extends CommonConditions {
    private static final String DESTINATION = "Minsk";
    private static final String DESTINATION_EXCEPTION_TEXT = "To start, tell us where you're going";
    private static final String BIG_GROUP_HINT_TEXT = "Big group? Try Hotelplanner.com for 6+ rooms";
    private static final int NUMBER_OF_ADULTS = 4;
    private static final int BIG_NUMBER_OF_ADULTS = 99;
    private static final int MAX_NUMBER_OF_ADULTS = 48;

    @Test
    public void emptyDestinationFieldStaysPageTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);

        homePage.openHomePage();
        /*        .searchHotels();

        final String destinationExceptionText = homePage.getDestinationExceptionText();

        Assert.assertEquals(DESTINATION_EXCEPTION_TEXT, destinationExceptionText);
    */
    }
/*
    @Test
    public void bigGroupHintStaysPageTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);

        final String bigGroupHintText = homePage.openHomePage()
                                                .openRoomForm()
                                                .fillAdultsField(BIG_NUMBER_OF_ADULTS)
                                                .getBigGroupHintText();

        Assert.assertEquals(BIG_GROUP_HINT_TEXT, bigGroupHintText);
    }

    @Test
    public void maxNumberOfAdultsStaysPageTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);

        homePage.openHomePage()
                .openRoomForm()
                .fillAdultsField(BIG_NUMBER_OF_ADULTS)
                .clickRoomFormApplyButton();

        final int maxNumberOfAdults = Integer.parseInt(homePage.getNumberOfAdults());

        Assert.assertEquals(MAX_NUMBER_OF_ADULTS, maxNumberOfAdults);
    }

    @Test
    public void findStaysTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);
        TrivagoStaysResultsPage resultsPage = homePage.openHomePage()
                                                      .enterDestination(DESTINATION)
                                                      .openRoomForm()
                                                      .fillAdultsField(NUMBER_OF_ADULTS)
                                                      .searchHotels();

        Assert.assertTrue(resultsPage.isInitialized());
    }
    */
}
