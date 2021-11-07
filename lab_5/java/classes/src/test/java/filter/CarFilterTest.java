package filter;

import car.Car;
import org.testng.Assert;
import org.testng.annotations.Test;
import property.CarColor;
import property.CarMark;

import java.util.ArrayList;
import java.util.Arrays;

public class CarFilterTest {
    private final Car[] CARS = {new Car(0, CarMark.TESLA, "S", 2012, CarColor.RED,9_999, "TSL_S_0"),
                                new Car(1, CarMark.AUDI, "S", 2014, CarColor.BLACK, 7_499, "AU_S_1"),
                                new Car(2, CarMark.CHEVROLET, "Camaro", 2016, CarColor.BLUE, 14_999, "CH_C_2"),
                                new Car(3, CarMark.CHEVROLET, "Rezzo", 2000, CarColor.BLACK, 5_000, "CH_R_3"),
                                new Car(4, CarMark.TESLA, "3", 2016, CarColor.GREEN, 14_999, "TSL_3_4"),
                                new Car(5, CarMark.AUDI, "TT", 2016, CarColor.WHITE, 9_500, "AU_TT_5"),
                                new Car(6, CarMark.TESLA, "X", 2015, CarColor.GREEN, 12_999, "TSL_X_6"),
                                new Car(7, CarMark.TESLA, "Y", 2020, CarColor.RED, 19_999, "TSL_Y_7"),
                                new Car(8, CarMark.CHEVROLET, "Rezzo", 2014, CarColor.GREEN, 19_999, "CH_R_8")
    };

    private final CarMark FILTER_MARK = CarMark.AUDI;
    private final String FILTERED_MODEL = "Rezzo";
    private final int FILTERED_EXPLOITATION_TIME = 9;
    private final int FILTERED_ISSUE_YEAR = 2016;
    private final int FILTERED_PRICE = 9_999;

    @Test
    public void filterCarsByMark() {
        final ArrayList<Car> CARS_FILTERED_BY_MARK =
                new ArrayList<>(Arrays.asList(new CarFilter().filterByMark(CARS, FILTER_MARK)));
        Assert.assertTrue(CARS_FILTERED_BY_MARK.size() == 2 &&
                          CARS_FILTERED_BY_MARK.containsAll(Arrays.asList(CARS[1], CARS[5])));
    }

    @Test
    public void filterCarsByModelAndExploitationTime() {
        final ArrayList<Car> CARS_FILTERED_BY_MODEL_AND_EXPLOITATION_TIME =
                new ArrayList<>(Arrays.asList(
                        new CarFilter().filterByModelAndExploitationTime(CARS,
                                                                         FILTERED_MODEL,
                                                                         FILTERED_EXPLOITATION_TIME)));
        Assert.assertTrue(CARS_FILTERED_BY_MODEL_AND_EXPLOITATION_TIME.size() == 1 &&
                          CARS_FILTERED_BY_MODEL_AND_EXPLOITATION_TIME.contains(CARS[3]));
    }

    @Test
    public void filterCarsByIssueYearAndPrice() {
        final ArrayList<Car> CARS_FILTERED_BY_ISSUE_YEAR_AND_PRICE =
                new ArrayList<>(Arrays.asList(
                        new CarFilter().filterByIssueYearAndPrice(CARS,
                                                                  FILTERED_ISSUE_YEAR,
                                                                  FILTERED_PRICE)));
        Assert.assertTrue(CARS_FILTERED_BY_ISSUE_YEAR_AND_PRICE.size() == 2 &&
                          CARS_FILTERED_BY_ISSUE_YEAR_AND_PRICE.containsAll(Arrays.asList(CARS[2], CARS[4])));
    }
}
