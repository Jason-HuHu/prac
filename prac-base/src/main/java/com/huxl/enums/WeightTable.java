package com.huxl.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO..
 *
 * @author xiaoh
 * @since 2019/2/19 10:11
 */
public class WeightTable {
    public static void main(String[] args) {
        double earthWeight = Double.parseDouble(args[0]);

        double mass = earthWeight / Planet.EARTH.surfaceGravity();

        for (Planet planet : Planet.values()) {
            System.out.printf("Weight On %s is %f%n",planet,planet.surfaceWeight(mass));
        }
        List<String> list =  new ArrayList<>();

        list.forEach(System.out::printf);


    }
}
