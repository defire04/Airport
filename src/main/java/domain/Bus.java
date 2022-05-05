package domain;

import java.util.List;
import java.util.Objects;

public class Bus implements Runnable {
    private final String driveTo;
    private int placesLeft;
    private List<Family> familyList;


    public Bus(int placesLeft, String driveTo) {
        this.placesLeft = placesLeft;
        this.driveTo = driveTo;
    }

    public int getPlacesLeft() {
        return placesLeft;
    }

    public void setPlacesLeft(int placesLeft) {
        this.placesLeft = placesLeft;
    }

    public String getDriveTo() {
        return driveTo;
    }

    public List<Family> getFamilyList() {
        return familyList;
    }

    public void setFamilyList(List<Family> familyList) {
        this.familyList = familyList;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "passengersCount=" + placesLeft +
                ", driveTo='" + driveTo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bus bus = (Bus) o;
        return Objects.equals(driveTo, bus.driveTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driveTo);
    }

    @Override
    public void run() {
        System.out.println(this + "took families to the city" + this.driveTo);
    }
}
