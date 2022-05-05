package business;

import domain.Bus;
import domain.Family;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TourOperator {
    public static void sortingPassengersByCity(List<Family> familyList) {

        List<Bus> busList = new ArrayList<>();

        int placesLeftTemp;
        int familyMembersTemp;
        AtomicInteger res = new AtomicInteger();
        familyList.forEach(family -> res.addAndGet(family.getMembers()));
        System.out.println(res);
        try {
            for (Family family : familyList) {
                String familyTravelTo = family.getTravelTo();

                if (!(busList.contains(new Bus(0, familyTravelTo)))) {
                    busList.add(new Bus((int) (Math.random() * 3) + 6, familyTravelTo));
                }
                familyMembersTemp = family.getMembers();
                for (Bus bus : busList) {
                    placesLeftTemp = bus.getPlacesLeft();

                    if (familyTravelTo.equals(bus.getDriveTo())) {


                        if (placesLeftTemp == 0) {
                            new Thread(bus).start();
                            busList.remove(bus);
                        } else if (placesLeftTemp - familyMembersTemp > -1) {
                            bus.setPlacesLeft(placesLeftTemp - familyMembersTemp);
                            bus.getFamilyList().add(family);
                            break;
                        } else {
                            Bus newBus = new Bus(((int) (Math.random() * 3) + 6), familyTravelTo);
                            busList.add(newBus);
                            newBus.setPlacesLeft(newBus.getPlacesLeft() - familyMembersTemp);
                            newBus.getFamilyList().add(family);
                            break;
                        }
                    }
                }
            }


        } finally {
//            busList.forEach(System.out::println);
            for (Bus bus : busList) {
                if (!bus.getFamilyList().isEmpty()) {
//                    new Thread(bus).start();
                    System.out.println(bus);
                }
            }
        }
    }


    public static void sortingPassengersByCity2(List<Family> familyList) {
        List<Bus> busListToKalush = new ArrayList<>();
        List<Bus> busList = new ArrayList<>();

        for (Family family : familyList) {
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
                        busToKalush.getFamilyList().add(family);
                        break;
                    } else if (placesLeftTemp - familyMembersTemp < 0) {
                        Bus newBus = new Bus((int) (Math.random() * 3) + 6, "Kalush");
                        busListToKalush.add(newBus);
                        newBus.setPlacesLeft(newBus.getPlacesLeft() - familyMembersTemp);
                        newBus.getFamilyList().add(family);
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
}
