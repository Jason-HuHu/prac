package com.huxl.java8.chapter8;

import java.util.Arrays;
import java.util.List;

/**
 * TODO..
 *
 * @author huxl
 * @since 2019/12/5-14:38
 */
public class ForStreamDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","q","2");
        list.forEach(System.out::println);
    }
}
