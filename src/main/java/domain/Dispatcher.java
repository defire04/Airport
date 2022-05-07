package domain;

import java.util.List;

import business.BorderService;
import domain.factory.PlaneFactory;

public class Dispatcher {
    public static void main(String[] args) {
        List<Plane> arrivalList = PlaneFactory.createPlanes();
        System.out.println("Arrive " + arrivalList.size() + " planes");


        Tester.setFamilyForTest(new Family("Millers", "Kiev", 4));
//        Tester.setEveryoneTravelToOneDirection(arrivalList, "Kiev");

        BorderService.arrivalOfFamiliesToAirport(arrivalList);

        Tester.getTestHowManyPeopleTravelToEachDirection();
//        Tester.getAllFamilies();


//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.println(i + " J=" + j);
//            }
//
//            if (i % 2 == 0) {
//                System.out.println("i" + i);
//            }
//        }
    }
}


