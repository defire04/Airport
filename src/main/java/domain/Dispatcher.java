package domain;

import business.BorderService;
import business.TourOperator;
import domain.factory.FamilyFactory;
import domain.factory.PlaneFactory;

import java.util.ArrayList;
import java.util.Collections;
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


        List<Plane> test = PlaneFactory.createPlanes();
        System.out.println("Arrive " + test.size() + " planes");


//        String[] cities = {"Kalush", "Kosiv", "Galych", "Kolomia"};
//        int ka = 0;
//        int ko = 0;
//        int ga = 0;
//        int kol = 0;
//        for (Plane plane : test) {
//            for (Family family : plane.getFamilies()) {
//                String travelTo = family.getTravelTo();
//                if (travelTo.equals(cities[0])) {
//                    ka += family.getMembers();
//                } else if (travelTo.equals(cities[1])) {
//                    ko += family.getMembers();
//                } else if (travelTo.equals(cities[2])) {
//                    ga += family.getMembers();
//                } else if (travelTo.equals(cities[3])) {
//                    kol += family.getMembers();
//                }
//            }
//        }
//        System.out.println(
//                cities[0] + " " + ka + " \n" +
//                        cities[1] + " " + ko + " \n" +
//                        cities[2] + " " + ga + " \n" +
//                        cities[3] + " " + kol
//
//        );

//        Map<Object, Long> infoAboutNumberOfPeopleTravelTo = test.stream().collect(Collectors.groupingBy(plane -> plane.getFamilies().stream().map(Family::getTravelTo), Collectors.counting()));
//        infoAboutNumberOfPeopleTravelTo.forEach((key, value) -> System.out.println(key + " " + value));

        for (Plane plane : test) {
            System.out.println("----------------------------------------------\n" +
                    "From plane number " + plane.getFlightNumber() + " "+ plane.getFamilies().size() + " families arrived!\n" +
                    "People traveling to the following cities:");
            plane.getFamilies()
                    .stream().collect(Collectors.groupingBy(
                            Family::getTravelTo, Collectors.counting())
                    ).forEach((key, value) -> System.out.println(key + " " + value));
        }

        BorderService.arrivalOfFamiliesToAirport(test);

//        TourOperator.sortingPassengersByCity(test);

//        List<Car> carList = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            carList.add(new Car(("a" + i), i));
//        }
//
//
//        for (Car car : carList) {
//            if(car.number % 2 == 0){
//                carList.remove(car);
//            }
//        }
//        carList.forEach(System.out::println);
    }
}


class Car {
    String model;
    int number;

    public Car(String model, int number) {
        this.model = model;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", number=" + number +
                '}';
    }
}