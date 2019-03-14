package com.huxl.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * TODO..
 *
 * @author xiaoh
 * @since 2019/2/22 14:48
 */
public class ArrayDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);

        List<Integer> list2 = new ArrayList<>();
        for (Integer integer : list) {
            list2.add(integer);
        }

        System.out.println(list2.get(0));
        System.out.println(("B0X".compareTo("B0A")));

        List<String> sortList = new ArrayList<>();
        sortList.add("B0A");
        sortList.add("B0B");
        sortList.add("B0X");
        sortList.add("B0A");

//        Collections.sort(sortList,(o1, o2) -> o2.compareTo(o1));
        sortList.sort((o1, o2) -> o2.compareTo(o1));
        System.out.println(sortList.get(1));
    }

}
