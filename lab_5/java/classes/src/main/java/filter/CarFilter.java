package filter;

import car.Car;
import property.CarMark;

import java.time.LocalDate;
import java.util.Arrays;

public class CarFilter {
    public Car[] filterByMark(Car[] cars, CarMark mark){
        return Arrays.stream(cars)
                     .filter(car -> car.getMark().equals(mark))
                     .toArray(Car[]::new);
    }

    public Car[] filterByModelAndExploitationTime(Car[] cars, String model, int exploitationTime){
        return Arrays.stream(cars)
                     .filter(car -> car.getModel().equals(model) && LocalDate.now().getYear() - car.getIssueYear() > exploitationTime)
                     .toArray(Car[]::new);
    }

    public Car[] filterByIssueYearAndPrice(Car[] cars, int issueYear, int price){
        return Arrays.stream(cars)
                     .filter(car -> car.getIssueYear() == issueYear && car.getPrice() > price)
                     .toArray(Car[]::new);
    }
}
