package com.huxl.designpattern.abstractFactory.color;

/**
 * @author huxl
 * @createDate 2018/3/21 18:42
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
