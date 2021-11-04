import airport.Airport;
import model.ClassificationLevel;
import model.ExperimentalType;
import model.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import plane.ExperimentalPlane;
import plane.MilitaryPlane;
import plane.PassengerPlane;
import plane.Plane;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AirportTest {
    private static final List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static final PassengerPlane passengerPlaneWithMaxPassengerCapacity =
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    private static final Comparator<Plane> PLANE_COMPARATOR_BY_MAX_LOAD_CAPACITY =
            Comparator.comparingInt(Plane::getMaxLoadCapacity);

    @Test
    public void hasTransportMilitaryPlaneTest() {
        Assert.assertFalse(new Airport(planes).getTransportMilitaryPlanes().isEmpty());
    }

    @Test
    public void comparePassengerPlaneWithMaxCapacityTest() {
        Assert.assertEquals(new Airport(planes).getPassengerPlaneWithMaxPassengersCapacity(),
                passengerPlaneWithMaxPassengerCapacity);
    }

    @Test
    public void sortPlanesByMaxLoadCapacityTest() {
        Airport airport = new Airport(planes);
        airport.sortPlanesByMaxLoadCapacity();
        Assert.assertEquals(planes, airport.getPlanes()
                                    .stream()
                                    .sorted(PLANE_COMPARATOR_BY_MAX_LOAD_CAPACITY)
                                    .collect(Collectors.toList()));
    }

    @Test
    public void hasBomberMilitaryPlaneTest() {
        Assert.assertFalse(new Airport(planes).getBomberMilitaryPlanes().isEmpty());
    }

    @Test
    public void hasNotUnclassifiedExperimentalPlaneTest(){
        Assert.assertTrue(new Airport(planes).getUnclassifiedExperimentalPlanes().isEmpty());
    }
}
