package domain;


import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
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
        this.familyList = new ArrayList<>();
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
                "passengersCount=" + this.passengersCount + " placeLeft=" + this.placesLeft +
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

    @Override
    public int hashCode() {
        return Objects.hash(driveTo);
    }

    @Override
    public void run() {
        System.out.println(this.passengersCount + " local bus brought " + this.familyList.stream().mapToInt(Family::getMembers).sum() + " people to " + this.driveTo +
                " Families =" + this.familyList);
    }

    public void busArrived() {
        System.out.println(this.passengersCount + " local bus brought " + this.familyList.stream().mapToInt(Family::getMembers).sum() + " people to " + this.driveTo +
                " Families =" + this.familyList);
    }

    public boolean isBusSuitable(Family family){
        return this.placesLeft - family.getMembers() > -1;
    }
}
