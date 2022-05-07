package business;

import domain.Bus;
import domain.Family;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TourToCity implements Runnable {
    private final String city;
    private List<Family> familiesToCityList;
    private List<Bus> busList = new ArrayList<>();

    public TourToCity(String city, List<Family> familiesToCity) {
        this.city = city;
        this.familiesToCityList = familiesToCity;
        new Thread(this).start();
        System.out.println("Created TourToCity!");
    }

    public String getCity() {
        return city;
    }

    public List<Family> getFamiliesToCity() {
        return familiesToCityList;
    }

    public void setFamiliesToCity(List<Family> familiesToCity) {
        this.familiesToCityList = familiesToCity;
    }

    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    @Override
    public void run() {
        boardingToBus(familiesToCityList);
//        System.out.println("-----");
    }

    private void boardingToBus(List<Family> familiesToCityList) {
        System.out.println("------");
        if (busList.isEmpty()) {
            busList.add(new Bus(((int) (Math.random() * 3) + 6), city));
        }
        for (Family family : familiesToCityList) {
            for (Bus bus : busList) {
                if (bus.getPlacesLeft() - family.getMembers() > -1) {
                    bus.setPlacesLeft(bus.getPlacesLeft() - family.getMembers());
                    bus.getFamilyList().add(family);
                    if (bus.getPlacesLeft() == 0) {
//                        new Thread(bus).start();
                        bus.busArrived(); // Если нужно проверить что незаполненый приезжает последним
                        busList.remove(bus);
                    }
                } else {
                    Bus newBus = new Bus(((int) (Math.random() * 3) + 6), city);
                    busList.add(newBus);
                    newBus.setPlacesLeft(newBus.getPlacesLeft() - family.getMembers());
                    newBus.getFamilyList().add(family);
                }
                break;

            }
        }

        System.out.println(busList);
        checkingIfTheLastBusIsGoingInThatDirection(busList);
    }


    private void checkingIfTheLastBusIsGoingInThatDirection(List<Bus> busList) {

        List<Family> newFamiliesList = new ArrayList<>();
        if (!busList.isEmpty()) {

            if (busList.size() == 1) {
                busList.forEach(Bus::busArrived);
            } else {
                for (Bus bus : busList) {
                    newFamiliesList.addAll(bus.getFamilyList());
                    System.out.println("11");
                }
            }

            if (!newFamiliesList.isEmpty()) {
                boardingToBus(newFamiliesList);
            }

        }
    }


//        List<Family> newFamilyList = new ArrayList<>();
//
//
//        if (busList.size() > 1) {
//            busList.forEach(bus -> newFamilyList.addAll(bus.getFamilyList()));
//
//        } else {
////                bus.getValue().forEach(bus1 -> new Thread(bus1).start());
//            busList.forEach(Bus::busArrived); // Если нужно проверить что незаполненый приезжает последним
//
//        }
//
//        if (!newFamilyList.isEmpty()) {
//            boardingToBus(newFamilyList);
//        }
//    }

}
