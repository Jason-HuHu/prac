package com.huxl.java8.chaptrer9;

/**
 *
 * @author huxl
 * @since 2019/12/5-18:43
 */
public interface A1 {

    default void hello(){
        System.out.println("Hello from A1");
    }

    default void baybay(){
        System.out.println("Bay Bay from A1");
    }
}
