package domain;

import business.BorderService;
import business.TourOperator;
import domain.factory.FamilyFactory;
import domain.factory.PlaneFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Dispatcher {
    public static void main(String[] args) {
//        FamilyFactory.createFamilies().forEach(System.out::println);
//        System.out.println("----------------------------");
//        List<Plane> planeList = PlaneFactory.createPlanes();
//        planeList.forEach(System.out::println);
//        planeList.forEach(plane -> System.out.println(plane.getFamilies()));


        List<Plane> test = List.of(
                PlaneFactory.createPlanes().get(0)
        );

//        test.forEach(plane -> plane.getFamilies().forEach(family -> family.setTravelTo("Kalush")));
        test.forEach(plane -> plane.getFamilies().forEach(System.out::println));
        String[] cities = {"Kalush", "Kosiv", "Galych", "Kolomia"};
        for (Plane plane : test) {
            int ka = 0;
            int ko = 0;
            int ga = 0;
            int kol = 0;
            for (Family family : plane.getFamilies()) {
                String travelTo = family.getTravelTo();
                if (travelTo.equals(cities[0])) {
                    ka += family.getMembers();
                } else if (travelTo.equals(cities[1])) {
                    ko += family.getMembers();
                } else if (travelTo.equals(cities[2])) {
                    ga += family.getMembers();
                } else if (travelTo.equals(cities[3])) {
                    kol += family.getMembers();
                }
            }

            System.out.println(
                    cities[0] + " " + ka + " \n" +
                            cities[1] + " " + ko + " \n" +
                            cities[2] + " " + ga + " \n" +
                            cities[3] + " " + kol

            );
        }

        BorderService.arrivalOfFamiliesToAirport(test);

//        TourOperator.sortingPassengersByCity(test);


//        for (int i = 0; i < 40; i++) {
//            System.out.println((int) (Math.random() * 4));
//        }
    }
}
