package plane;

import model.ClassificationLevel;
import model.ExperimentalType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ExperimentalPlaneTest {
    private static final ExperimentalPlane EXPERIMENTAL_PLANE =
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET);
    private static final String EXPERIMENTAL_PLANE_AS_STRING =
            "Plane{model='Bell X-14', maxSpeed=277, maxFlightDistance=482, maxLoadCapacity=500type=HIGH_ALTITUDE, classificationLevel=SECRET}";
    private static final ExperimentalType HIGH_ALTITUDE_EXPERIMENTAL_TYPE = ExperimentalType.HIGH_ALTITUDE;
    private static final ClassificationLevel SECRET_EXPERIMENTAL_CLASSIFICATION_LEVEL = ClassificationLevel.SECRET;
    private static final ClassificationLevel TOP_SECRET_EXPERIMENTAL_CLASSIFICATION_LEVEL = ClassificationLevel.TOP_SECRET;
    private static final ExperimentalPlane EXPERIMENTAL_PLANE_WITH_SAME_ARGUMENTS =
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET);
    private static final ExperimentalPlane ANOTHER_EXPERIMENTAL_PLANE =
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET);

    @Test
    public void compareExperimentalPlaneType() {
        Assert.assertEquals(EXPERIMENTAL_PLANE.getType(), HIGH_ALTITUDE_EXPERIMENTAL_TYPE);
    }

    @Test
    public void compareExperimentalPlaneClassificationLevel() {
        Assert.assertEquals(EXPERIMENTAL_PLANE.getClassificationLevel(), SECRET_EXPERIMENTAL_CLASSIFICATION_LEVEL);
    }

    @Test
    public void changeExperimentalPlaneClassificationLevel() {
        final ClassificationLevel oldClassificationLevel = EXPERIMENTAL_PLANE.getClassificationLevel();
        EXPERIMENTAL_PLANE.setClassificationLevel(TOP_SECRET_EXPERIMENTAL_CLASSIFICATION_LEVEL);
        Assert.assertNotEquals(EXPERIMENTAL_PLANE.getClassificationLevel(), oldClassificationLevel);
    }

    @AfterMethod
    private void changeBackClassificationLevel() {
        EXPERIMENTAL_PLANE.setClassificationLevel(SECRET_EXPERIMENTAL_CLASSIFICATION_LEVEL);
    }

    @Test
    public void compareExperimentalPlaneStringForm() {
        Assert.assertEquals(EXPERIMENTAL_PLANE.toString(), EXPERIMENTAL_PLANE_AS_STRING);
    }

    @Test
    public void compareIdenticalExperimentalPlanesTest() {
        Assert.assertEquals(EXPERIMENTAL_PLANE, EXPERIMENTAL_PLANE_WITH_SAME_ARGUMENTS);
    }

    @Test
    public void compareNotIdenticalExperimentalPlanesTest() {
        Assert.assertNotEquals(EXPERIMENTAL_PLANE, ANOTHER_EXPERIMENTAL_PLANE);
    }
}
