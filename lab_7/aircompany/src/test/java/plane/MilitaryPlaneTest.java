package plane;

import model.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilitaryPlaneTest {
    private static final MilitaryPlane MILITARY_PLANE =
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000,MilitaryType.BOMBER);
    private static final String MILITARY_PLANE_AS_STRING =
            "Plane{model='B-1B Lancer', maxSpeed=1050, maxFlightDistance=21000, maxLoadCapacity=80000, type=BOMBER}";
    private static final MilitaryType BOMBER_MILITARY_TYPE = MilitaryType.BOMBER;
    private static final MilitaryPlane MILITARY_PLANE_WITH_SAME_ARGUMENTS =
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000,MilitaryType.BOMBER);
    private static final MilitaryPlane ANOTHER_MILITARY_PLANE =
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER);

    @Test
    public void compareMilitaryPlaneType() {
        Assert.assertEquals(MILITARY_PLANE.getType(), BOMBER_MILITARY_TYPE);
    }

    @Test
    public void compareMilitaryPlaneStringForm() {
        Assert.assertEquals(MILITARY_PLANE.toString(), MILITARY_PLANE_AS_STRING);
    }

    @Test
    public void compareIdenticalMilitaryPlanesTest() {
        Assert.assertEquals(MILITARY_PLANE, MILITARY_PLANE_WITH_SAME_ARGUMENTS);
    }

    @Test
    public void compareNotIdenticalMilitaryPlanesTest() {
        Assert.assertNotEquals(MILITARY_PLANE, ANOTHER_MILITARY_PLANE);
    }
}
