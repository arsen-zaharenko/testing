package car;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import property.CarColor;
import property.CarMark;

public class CarTest {
    private final Car CAR = new Car(0,CarMark.TESLA,"S",2018, CarColor.WHITE, 10_500,"TSL_S_0");
    private final String CAR_STRING_VALUE = "Car{id=0, mark=TESLA, model='S', issueYear=2018, color=WHITE, price=10500, number='TSL_S_0'}";
    private final int ID = 0;
    private final CarMark MARK = CarMark.TESLA;
    private final String MODEL = "S";
    private final int ISSUE_YEAR = 2018;
    private final CarColor COLOR = CarColor.WHITE;
    private final int PRICE = 10_500;
    private final String NUMBER = "TSL_S_0";

    private final CarColor ANOTHER_COLOR = CarColor.BLUE;
    private final int ANOTHER_PRICE = 9_200;
    private final String ANOTHER_NUMBER = "CAR";

    private final Car CAR_WITHOUT_PRICE_AND_NUMBER = new Car(1, CarMark.AUDI,"TT",2019, CarColor.RED);
    private final double NO_PRICE_VALUE = 0;
    private final String NO_NUMBER_VALUE = "unregistered";

    @Test
    public void changeCarColorPriceNumber() {
        CAR.setColor(ANOTHER_COLOR);
        CAR.setPrice(ANOTHER_PRICE);
        CAR.setNumber(ANOTHER_NUMBER);
        Assert.assertTrue((CAR.getColor() != COLOR && CAR.getColor() == ANOTHER_COLOR) &&
                          (CAR.getPrice() != PRICE && CAR.getPrice() == ANOTHER_PRICE) &&
                          (CAR.getNumber() != NUMBER && CAR.getNumber() == ANOTHER_NUMBER));
    }

    @AfterMethod
    public void changeBackCarColorPriceNumber() {
        CAR.setColor(COLOR);
        CAR.setPrice(PRICE);
        CAR.setNumber(NUMBER);
    }

    @Test
    public void compareCarFields() {
        Assert.assertTrue(CAR.getId() == ID &&
                          CAR.getMark() == MARK &&
                          CAR.getModel() == MODEL &&
                          CAR.getIssueYear() == ISSUE_YEAR &&
                          CAR.getColor() == COLOR &&
                          CAR.getPrice() == PRICE &&
                          CAR.getNumber() == NUMBER);
    }

    @Test
    public void compareCarStringValue() {
        Assert.assertEquals(CAR.toString(), CAR_STRING_VALUE);
    }

    @Test
    public void createCarWithoutPriceAndNumber() {
        Assert.assertTrue(CAR_WITHOUT_PRICE_AND_NUMBER.getPrice() == NO_PRICE_VALUE &&
                          CAR_WITHOUT_PRICE_AND_NUMBER.getNumber() == NO_NUMBER_VALUE);
    }

}
