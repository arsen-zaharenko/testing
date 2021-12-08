package model;

public class Date {
    private String departDate;
    private String returnDate;

    public Date(String departDate, String returnDate) {
        this.departDate = departDate;
        this.returnDate = returnDate;
    }

    public String getDepartDate() {
        return departDate;
    }

    public String getReturnDate() {
        return returnDate;
    }
}
