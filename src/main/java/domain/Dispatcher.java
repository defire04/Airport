package domain;

import domain.factory.PlaneFactory;

import java.util.List;

public class Dispatcher {
    public static void main(String[] args) {
//        System.out.println(PlaneFactory.surnameCreator());

        List<Family> res = PlaneFactory.createFamilies();

        res.forEach(System.out::println);
        System.out.println(res.size());

//        List<Plane> planesArrivalList = List.of(
//
//        );
    }
}
