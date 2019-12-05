package com.huxl.java8.chapter8;

import java.util.Arrays;
import java.util.List;

/**
 * TODO..
 *
 * @author huxl
 * @since 2019/12/5-14:37
 */
public class ForEachDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","q","2");
        System.out.println("-------------------");
        for (String s :list) {
            System.out.println(s);
        }
        System.out.println("-------------------");
        list.forEach(System.out::println);

    }
}
