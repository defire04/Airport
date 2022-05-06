package domain.factory;

import domain.Plane;
import domain.Family;

import java.util.List;
import java.util.ArrayList;

public class FamilyFactory {
    public static List<Family> createFamilies() {

        List<Family> familiesInPlane = new ArrayList<>();
        List<String> surnameList = createSurnames();

        String[] cities = {"Kalush", "Kosiv", "Galych", "Kolomia"};

        int countOfMembers = 0;
        int countPeopleInPlane = 0;

        while (!(countPeopleInPlane == Plane.SEATS)) {
            countOfMembers = (int) (Math.random() * 3) + 1;
            countPeopleInPlane += countOfMembers;
            if (countPeopleInPlane < Plane.SEATS + 1) {
                familiesInPlane.add(new Family(
                        surnameList.get((int) (Math.random() * surnameList.size())),
                        cities[(int) (Math.random() * 4)],
                        countOfMembers));
            } else {
                countPeopleInPlane -= countOfMembers;
            }
        }
        return familiesInPlane;
    }


    protected static List<String> createSurnames() {
        List<String> resultSurnameSet = new ArrayList<>();
        String[] surnameCreator = "abcdefghijklmnopqrstuvwxyz".split("");

        for (String symbol : surnameCreator) {
            for (String symbol2 : surnameCreator) {
                resultSurnameSet.add(symbol + symbol2);
            }
        }
        return resultSurnameSet;
    }
}

