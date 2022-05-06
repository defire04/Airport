package business;

import domain.Bus;
import domain.Family;

import java.util.*;
import java.util.stream.Collectors;

public class TourOperator {

    public static void sortingPassengersByCity(List<Family> familyList) {

        List<Bus> busList = new ArrayList<>();
//        System.out.println(familyList.stream().collect(Collectors.summarizingLong(Family::getMembers)).getSum());
        int placesLeftTemp;
        int familyMembersTemp;
        String familyTravelTo;
        for (Family family : familyList) {
            familyTravelTo = family.getTravelTo();
            if (!(busList.contains(new Bus(0, familyTravelTo)))) {
                busList.add(new Bus((int) (Math.random() * 3) + 6, familyTravelTo));
            }
            familyMembersTemp = family.getMembers();
            for (Bus bus : busList) {
                if (familyTravelTo.equals(bus.getDriveTo())) {
                    placesLeftTemp = bus.getPlacesLeft();
                    if (placesLeftTemp - familyMembersTemp > -1) {
                        bus.setPlacesLeft(placesLeftTemp - familyMembersTemp);
                        bus.getFamilyList().add(family);
                        if (bus.getPlacesLeft() == 0) {
                            new Thread(bus).start();
//                                bus.busArrived(); // Если нужно проверить что незаполненый приезжает последним
                            busList.remove(bus);
                        }
                    } else {
                        Bus newBus = new Bus(((int) (Math.random() * 3) + 6), familyTravelTo);
                        busList.add(newBus);
                        newBus.setPlacesLeft(newBus.getPlacesLeft() - familyMembersTemp);
                        newBus.getFamilyList().add(family);
                    }
                    break;
                }
            }
        }

        checkingIfTheLastBusIsGoingInThatDirection(busList);
    }

    private static void checkingIfTheLastBusIsGoingInThatDirection(List<Bus> busList) {
        busList.removeIf(bus -> bus.getFamilyList().isEmpty());
        Map<String, List<Bus>> busInfoMap = busList.stream().collect(Collectors.groupingBy(
                Bus::getDriveTo, Collectors.toList()
        ));

        List<Family> newFamilyList = new ArrayList<>();

        for (Map.Entry<String, List<Bus>> bus : busInfoMap.entrySet()) {
            if (bus.getValue().size() > 1) {
                bus.getValue().forEach(bus1 -> newFamilyList.addAll(bus1.getFamilyList()));
            } else {
                bus.getValue().forEach(bus1 -> new Thread(bus1).start());
//                    bus.getValue().forEach(Bus::busArrived); // Если нужно проверить что незаполненый приезжает последним
            }
        }
        if (!newFamilyList.isEmpty()) {
            sortingPassengersByCity(newFamilyList);
        }
    }
}
