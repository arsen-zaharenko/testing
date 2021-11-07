package car;

import property.CarColor;
import property.CarMark;

public class Car {
    private final int id;
    private final CarMark mark;
    private final String model;
    private final int issueYear;
    private CarColor color;
    private int price;
    private String number;

    public Car(int id, CarMark mark, String model, int issueYear, CarColor color) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.issueYear = issueYear;
        this.color = color;
        this.price = 0;
        this.number = "unregistered";
    }

    public Car(int id, CarMark mark, String model, int issueYear, CarColor color, int price, String number) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.issueYear = issueYear;
        this.color = color;
        this.price = price;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public CarMark getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public int getIssueYear() {
        return issueYear;
    }

    public CarColor getColor() {
        return color;
    }

    public void setColor(CarColor color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark=" + mark +
                ", model='" + model + '\'' +
                ", issueYear=" + issueYear +
                ", color=" + color +
                ", price=" + price +
                ", number='" + number + '\'' +
                '}';
    }
}
