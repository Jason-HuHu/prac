package com.huxl.designpattern.prototype;

/**
 * TODO...
 *
 * @author huxl
 * @since 2018/3/22 16:57
 */
public class Square extends Shape {
    public Square() {
       type = "Square";
    }
    @Override
    void draw() {
        System.out.println("Inside Square:draw() method");
    }
}
