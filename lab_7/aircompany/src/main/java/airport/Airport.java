package airport;

import model.ClassificationLevel;
import model.ExperimentalType;
import model.MilitaryType;
import plane.ExperimentalPlane;
import plane.MilitaryPlane;
import plane.PassengerPlane;
import plane.Plane;

import java.util.*;
import java.util.stream.Collectors;

public class Airport {
    private final List<Plane> planes;

    public Airport(List<Plane> planes) {
        this.planes = planes;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return planes.stream()
                     .filter(PassengerPlane.class::isInstance)
                     .map(PassengerPlane.class::cast)
                     .collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return Collections.max(getPassengerPlanes(), Comparator.comparing(PassengerPlane::getPassengersCapacity));
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return planes.stream()
                     .filter(MilitaryPlane.class::isInstance)
                     .map(MilitaryPlane.class::cast)
                     .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanesByCertainType(MilitaryType militaryType) {
        return getMilitaryPlanes().stream()
                                  .filter(plane -> plane.getType().equals(militaryType))
                                  .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return planes.stream()
                     .filter(ExperimentalPlane.class::isInstance)
                     .map(ExperimentalPlane.class::cast)
                     .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanesByCertainType(ExperimentalType experimentalType) {
        return getExperimentalPlanes().stream()
                                      .filter(plane -> plane.getType().equals(experimentalType))
                                      .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanesByCertainClassificationLevel(ClassificationLevel classificationLevel) {
        return getExperimentalPlanes().stream()
                                      .filter(plane -> plane.getClassificationLevel().equals(classificationLevel))
                                      .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanesByCertainTypeAndClassificationLevel(
            ExperimentalType experimentalType, ClassificationLevel classificationLevel) {
        return getExperimentalPlanes().stream()
                .filter(plane -> plane.getType().equals(experimentalType))
                .filter(plane -> plane.getClassificationLevel().equals(classificationLevel))
                .collect(Collectors.toList());
    }

    public void sortPlanesByModel() { planes.sort(Comparator.comparing(Plane::getModel)); }

    public void sortPlanesByMaxFlightDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
    }

    public void sortPlanesByMaxSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
    }

    public void sortPlanesByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
    }
}
