package com.huxl.designpattern.decorator;

/**
 * @author huxl
 * @createDate 2018/3/16 12:01
 */
public class Rectangle implements IShape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
