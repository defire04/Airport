package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Plane implements Runnable {

    public static final int SEATS = 40;
    private final List<Family> families;
    private final int flightNumber;

    public Plane(List<Family> families, int flightNumber) {
        this.families = families;
        this.flightNumber = flightNumber;
        new Thread(this).start();
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

    @Override
    public void run() {
        infoAboutPeopleAboard();
    }

    private void infoAboutPeopleAboard() {
        System.out.println("----------------------------------------------\n" +
                "From plane number " + flightNumber + " " + families.size() + " families arrived!");
//                "People traveling to the following cities:");
//        families.stream().collect(Collectors.groupingBy(
//                Family::getTravelTo, Collectors.counting())
//        ).forEach((key, value) -> System.out.println(key + " " + value));
    }
}
