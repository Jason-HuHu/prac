package com.huxl.designpattern.abstractFactory.shape;

/**
 * @author huxl
 * @createDate 2018/3/21 17:03
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle :draw() method");
    }
}
