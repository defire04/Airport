package domain;

import java.util.List;

import business.BorderService;
import domain.factory.PlaneFactory;

public class Dispatcher {
    public static void main(String[] args) {

        List<Plane> test = PlaneFactory.createPlanes();
        System.out.println("Arrive " + test.size() + " planes");

        BorderService.arrivalOfFamiliesToAirport(test);
    }
}


