package com.huxl.java8.chaptrer9;

/**
 * TODO..
 *
 * @author huxl
 * @since 2019/12/5-18:44
 */
public class A2 implements A,A1 {

    @Override
    public void hello() {
        A.super.hello();
    }
}
