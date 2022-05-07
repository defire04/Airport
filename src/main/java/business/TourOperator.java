package business;

import domain.Bus;
import domain.Family;

import java.util.*;
import java.util.stream.Collectors;

public class TourOperator {

    public static void sortingPassengersByCity(List<Family> familyList) {

        Map<String, List<Family>> sortedToCityMap = familyList.stream()
                .collect(Collectors.groupingBy(Family::getTravelTo, Collectors.toList()));

        for (Map.Entry<String, List<Family>> cityTo : sortedToCityMap.entrySet()) {
            new TourToCity(cityTo.getKey(), cityTo.getValue());

        }
    }

}
