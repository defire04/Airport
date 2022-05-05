package domain;

import java.util.List;

public class Plane {

    public static final int SEATS = 40;
    private final List<Family> families;
    private final int flightNumber;

    public Plane(List<Family> families, int flightNumber) {
        this.families = families;
        this.flightNumber = flightNumber;
    }

    public List<Family> getFamilies() {
        return families;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "families=" + this.families +
                ", flightNumber=" + this.flightNumber +
                '}';
    }
}
