package com.huxl.designpattern.factory;

/**
 * @author huxl
 * @createDate 2018/3/21 17:03
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square :draw() method");
    }
}
