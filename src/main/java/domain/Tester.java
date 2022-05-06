package domain;

import business.BorderService;

import java.util.stream.Collectors;

public class Tester {
    public static void getTestHowManyPeopleTravelToEachDirection() {
        BorderService.allArrivingFamiliesAtAirport.stream().collect(Collectors.groupingBy(
                        Family::getTravelTo, Collectors.summingInt(Family::getMembers)))
                .forEach((key, value) -> System.out.println(key + " " + value));
    }

    public static void getAllFamilies() {
        BorderService.allArrivingFamiliesAtAirport.forEach(System.out::println);
    }

    public static void setFamilyForTest(Family family) {
        BorderService.allArrivingFamiliesAtAirport.add(family);
    }
}
