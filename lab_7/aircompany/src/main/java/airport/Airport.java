package airport;

import model.ClassificationLevel;
import model.MilitaryType;
import plane.ExperimentalPlane;
import plane.MilitaryPlane;
import plane.PassengerPlane;
import plane.Plane;

import java.util.*;

public class Airport {
    private final List<Plane> planes;

    public Airport(List<Plane> planes) {
        this.planes = planes;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();

        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) plane);
            }
        }

        return passengerPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane passengerPlaneWithMaxCapacity = passengerPlanes.get(0);

        for (int i = 1; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > passengerPlaneWithMaxCapacity.getPassengersCapacity()) {
                passengerPlaneWithMaxCapacity = passengerPlanes.get(i);
            }
        }

        return passengerPlaneWithMaxCapacity;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();

        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }

        return militaryPlanes;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();

        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if (militaryPlane.getType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(militaryPlane);
            }
        }

        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();

        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if (militaryPlane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(militaryPlane);
            }
        }

        return bomberMilitaryPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();

        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public List<ExperimentalPlane> getUnclassifiedExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = getExperimentalPlanes();
        List<ExperimentalPlane> unclassifiedExperimentalPlanes = new ArrayList<>();

        for (ExperimentalPlane experimentalPlane : experimentalPlanes) {
            if (experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED) {
                unclassifiedExperimentalPlanes.add(experimentalPlane);
            }
        }
        return unclassifiedExperimentalPlanes;
    }

    public void sortPlanesByMaxDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
    }

    public void sortPlanesByMaxSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
    }

    public void sortPlanesByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
    }

    @Override
    public String toString() {
        return "Airport{" + "Planes=" + planes + '}';
    }
}
