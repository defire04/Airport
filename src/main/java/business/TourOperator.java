package business;

import domain.Bus;
import domain.Family;
import domain.Plane;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TourOperator {
    public static void sortingPassengersByCity(List<Plane> planeList) {


        List<Bus> busListToKalush = new ArrayList<>();

        for (Plane plane : planeList) {
            for (Family family : plane.getFamilies()) {
                String familyTravelTo = family.getTravelTo();


                if (familyTravelTo.equals("Kalush")) {
                    int placesLeftTemp;
                    int familyMembersTemp;
                    if (busListToKalush.isEmpty()) {
                        busListToKalush.add(new Bus((int) (Math.random() * 3) + 6, "Kalush"));
                    }

                    for (Bus busToKalush : busListToKalush) {
                        placesLeftTemp = busToKalush.getPlacesLeft();
                        familyMembersTemp = family.getMembers();

                        if (placesLeftTemp == 0) {
                            new Thread(busToKalush).start();
                            busListToKalush.remove(busToKalush);
                            break;
                        }

                        if (placesLeftTemp - familyMembersTemp > -1) { //подходит ли автобус
                            busToKalush.setPlacesLeft(placesLeftTemp - familyMembersTemp);
                            break;
                        } else if (placesLeftTemp - familyMembersTemp < 0) {
                            Bus newBus = new Bus((int) (Math.random() * 3) + 6, "Kalush");
                            busListToKalush.add(newBus);
                            newBus.setPlacesLeft(newBus.getPlacesLeft() - familyMembersTemp);
                            break;
                        }
                    }

                } else if (familyTravelTo.equals("Kosiv")) {

                } else if (familyTravelTo.equals("Galych")) {

                } else if (familyTravelTo.equals("Kolomia")) {

                } else {

                }

            }
        }


//        planeList.forEach(plane -> {
//            AtomicInteger passengersCountIs = new AtomicInteger();
//            plane.getFamilies().forEach(family -> {
//                String familyTravelTo = family.getTravelTo();
//
//
//
//                if (familyTravelTo.equals("Kalush")) {
//                    if(passengersCountIs < busToKalush.getPassengersCount())
//
//                    passengersCountIs.addAndGet(family.getMembers());
//
//                } else if (familyTravelTo.equals("Kosiv")) {
//
//                } else if (familyTravelTo.equals("Galych")) {
//
//                } else if (familyTravelTo.equals("Kolomia")) {
//
//                } else {
//
//                }
//
//            });
//        });
    }
}
