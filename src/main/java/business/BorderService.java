package business;

import domain.Family;
import domain.Plane;

import java.util.ArrayList;
import java.util.List;


public class BorderService {
    public static List<Family> allArrivingFamiliesAtAirport = new ArrayList<>();

    public static void arrivalOfFamiliesToAirport(List<Plane> planeList){
        planeList.forEach(plane -> allArrivingFamiliesAtAirport.addAll(plane.getFamilies()));
        TourOperator.sortingPassengersByCity(allArrivingFamiliesAtAirport);
    }
}
