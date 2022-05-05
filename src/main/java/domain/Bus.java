package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Bus implements Runnable {
    private final String driveTo;
    private final int passengersCount;
    private int placesLeft;
    private List<Family> familyList;


    public Bus(int passengersCount, String driveTo) {
        this.passengersCount = passengersCount;
        this.placesLeft = passengersCount;
        this.driveTo = driveTo;
        familyList = new ArrayList<>();
    }

    public String getDriveTo() {
        return driveTo;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public int getPlacesLeft() {
        return placesLeft;
    }

    public void setPlacesLeft(int placesLeft) {
        this.placesLeft = placesLeft;
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
                "passengersCount=" + this.passengersCount +
                ", driveTo='" + this.driveTo + '\'' + this.familyList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return passengersCount == bus.passengersCount && placesLeft == bus.placesLeft && Objects.equals(driveTo, bus.driveTo) && Objects.equals(familyList, bus.familyList);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Bus bus = (Bus) o;
//        return Objects.equals(driveTo, bus.driveTo);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(driveTo);
    }

    @Override
    public void run() {
        AtomicInteger placesAreOccupied = new AtomicInteger();
        this.familyList.forEach(family -> placesAreOccupied.addAndGet(family.getMembers()));
        System.out.println(this.passengersCount + " local bus brought " + placesAreOccupied + " people to " + this.driveTo);
    }
}
