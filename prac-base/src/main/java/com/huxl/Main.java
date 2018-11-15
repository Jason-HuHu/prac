package com.huxl;


import java.util.*;

/**
 * TODO..
 *
 * @author huxingl
 * @since 2018/11/15 18:29
 */


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (in.hasNextInt()) {
            list.add(in.nextInt());
            if (list.size() == 10) {
                break;
            }
        }
        int sum = 0;
        for (Integer i : list) {
            sum+=i;
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        });
        int max = list.get(9);
        int  min = list.get(0);
        System.out.println(max + " " + min +" " + sum);
    }
}
