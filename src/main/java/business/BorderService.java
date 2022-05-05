package business;

import domain.Family;
import domain.Plane;

import java.util.ArrayList;
import java.util.List;


public class BorderService {
    public static List<Family> allArrivingFamiliesAtAirport = new ArrayList<>();

    public BorderService(List<Plane> planeList) {
        planeList.forEach(plane -> allArrivingFamiliesAtAirport.addAll(plane.getFamilies()));
        TourOperator.sortingPassengersByCity(allArrivingFamiliesAtAirport);
    }

    public static void arrivalOfFamiliesToAirport(List<Plane> planeList){
        planeList.forEach(plane -> allArrivingFamiliesAtAirport.addAll(plane.getFamilies()));
        TourOperator.sortingPassengersByCity(allArrivingFamiliesAtAirport);
    }


}
