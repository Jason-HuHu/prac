package com.huxl.designpattern.decorator;


/**
 * @author huxl
 * @createDate 2018/3/16 12:00
 */
public class Circle implements IShape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
