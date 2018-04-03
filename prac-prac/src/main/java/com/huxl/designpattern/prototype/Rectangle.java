package com.huxl.designpattern.prototype;

/**
 * TODO...
 *
 * @author huxl
 * @since 2018/3/22 16:57
 */
public class Rectangle extends Shape {
    public Rectangle() {
       type = "Rectangle";
    }
    @Override
    void draw() {
        System.out.println("Inside Rectangle:draw() method");
    }
}
