package business;

import domain.Bus;
import domain.Family;

import java.util.ArrayList;
import java.util.Collections;
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


//                            if (placesLeftTemp == 0) {
//                                new Thread(bus).start();
//                                busList.remove(bus);
//                            }
                        if (placesLeftTemp - familyMembersTemp > -1) {
                            bus.setPlacesLeft(placesLeftTemp - familyMembersTemp);
                            bus.getFamilyList().add(family);
                            if (bus.getPlacesLeft() == 0) {
                                System.out.println("222222222222222222222222222222222222222222222222222222222222");
                                new Thread(bus).start();
                                busList.remove(bus);
                            }
                            break;
                        } else {
                            Bus newBus = new Bus(((int) (Math.random() * 3) + 6), familyTravelTo);
                            busList.add(newBus);
                            newBus.setPlacesLeft(newBus.getPlacesLeft() - familyMembersTemp);
                            newBus.getFamilyList().add(family);
                            if (bus.getPlacesLeft() == 0) {
                                System.out.println("1111111111111111111111111111111111111111111111111111111111111111111111");
                                new Thread(bus).start();
                                busList.remove(bus);
                            }
                            break;
                        }
                    }
//                    if (bus.getPlacesLeft() == 0) {
//                        System.out.println("333333333333");
//                        new Thread(bus).start();
//                        busList.remove(bus);
//                        break;
//                    }
                }
            }


        } finally {
//            busList.forEach(System.out::println);
            System.out.println("----------------------------------------------------------------------------------");
            busList.removeIf(bus -> bus.getFamilyList().isEmpty());

            busList.forEach(System.out::println);
            System.out.println("============================");
            List<Family> newFamilyList = new ArrayList<>();
            int c = 0;
            if (!busList.isEmpty()) {
                for (Bus bus1 : busList) {
                    for (Bus bus2 : busList) {
                        if (!bus1.equals(bus2)) {
                            if (bus1.getDriveTo().equals(bus2.getDriveTo())) {
                                c++;
//                                bus1.getFamilyList().addAll(bus2.getFamilyList());
//                                busList.remove(bus2);
                            }
                        }
                    }
//                    System.out.println("-=---" + c + " " + bus1 + " ");
                    if (c > 1) {
                        System.out.println(bus1 + " " + c);
                        newFamilyList.addAll(bus1.getFamilyList());
                    } else {
                        new Thread(bus1).start();
                    }
                }
            }
            if (!newFamilyList.isEmpty()) {
                sortingPassengersByCity(newFamilyList);
            }

//            List<Family> NewFamilyList = new ArrayList<>();
//            for (Bus bus1 : busList) {
//                for (Bus bus2 : busList) {
//                    if(bus1.getDriveTo().equals(bus2.getDriveTo())){
//                        if(!bus1.equals(bus2)){
//
//
//                        }
//                    }
//                }
//            }


//            for (Bus bus : busList) {
//                if (!bus.getFamilyList().isEmpty()) {
//                    new Thread(bus).start();
////                    System.out.println(bus);
//                }
//            }
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
