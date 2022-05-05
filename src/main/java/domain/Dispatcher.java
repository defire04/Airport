package domain;

import business.TourOperator;
import domain.factory.FamilyFactory;
import domain.factory.PlaneFactory;

import java.util.List;

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

        test.forEach(plane -> plane.getFamilies().forEach(family -> family.setTravelTo("Kalush")));
        test.forEach(plane -> plane.getFamilies().forEach(System.out::println));

        TourOperator.sortingPassengersByCity(test);



    }
}
