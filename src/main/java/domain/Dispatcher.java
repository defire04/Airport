package domain;

import java.util.List;
import java.util.stream.Collectors;

import domain.Tester;
import business.BorderService;
import domain.factory.PlaneFactory;

public class Dispatcher {
    public static void main(String[] args) {
        List<Plane> arrivalList = PlaneFactory.createPlanes();
        System.out.println("Arrive " + arrivalList.size() + " planes");


//        Tester.setFamilyForTest(new Family("Millers", "Kiev", 4));
        arrivalList.forEach(plane -> plane.getFamilies().forEach(family -> family.setTravelTo("Kiev")));

        BorderService.arrivalOfFamiliesToAirport(arrivalList);

        Tester.getTestHowManyPeopleTravelToEachDirection();
//        Tester.getAllFamilies();
    }
}


