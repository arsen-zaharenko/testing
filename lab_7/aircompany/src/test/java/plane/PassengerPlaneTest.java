package plane;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PassengerPlaneTest {
    private static final PassengerPlane PASSENGER_PLANE =
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164);
    private static final String PASSENGER_PLANE_AS_STRING =
            "Plane{model='Boeing-737', maxSpeed=900, maxFlightDistance=12000, maxLoadCapacity=60500, passengersCapacity=164}";
    private static final int PASSENGER_PLANE_PASSENGER_CAPACITY = 164;
    private static final PassengerPlane PASSENGER_PLANE_WITH_SAME_ARGUMENTS =
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164);
    private static final PassengerPlane ANOTHER_PASSENGER_PLANE =
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192);

    @Test
    public void comparePassengerPlanePassengerCapacity() {
        Assert.assertEquals(PASSENGER_PLANE.getPassengersCapacity(), PASSENGER_PLANE_PASSENGER_CAPACITY);
    }

    @Test
    public void comparePassengerPlaneStringForm() {
        Assert.assertEquals(PASSENGER_PLANE.toString(), PASSENGER_PLANE_AS_STRING);
    }

    @Test
    public void compareIdenticalPassengerPlanesTest() {
        Assert.assertEquals(PASSENGER_PLANE, PASSENGER_PLANE_WITH_SAME_ARGUMENTS);
    }

    @Test
    public void compareNotIdenticalPassengerPlanesTest() {
        Assert.assertNotEquals(PASSENGER_PLANE, ANOTHER_PASSENGER_PLANE);
    }
}
