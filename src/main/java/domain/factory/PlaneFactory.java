package domain.factory;

import java.util.*;
import domain.Plane;

public class PlaneFactory {

    public static List<Plane> createPlanes(){
        List<Plane> planeResultList = new ArrayList<>();

        for (int i = 0; i < (int) (Math.random() * 3) + 3; i++) {
//        for (int i = 0; i < 1; i++) {
            planeResultList.add(new Plane(FamilyFactory.createFamilies(), i + 1));
        }
        return planeResultList;
    }
}
