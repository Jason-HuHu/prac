package com.huxl.designpattern.prototype;

/**
 * TODO...
 *
 * @author huxl
 * @since 2018/3/22 16:57
 */
public class Circle extends Shape {
    public Circle() {
       type = "Circle";
    }
    @Override
    void draw() {
        System.out.println("Inside Circle:draw() method");
    }
}
