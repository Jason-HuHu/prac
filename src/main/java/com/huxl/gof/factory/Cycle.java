package com.huxl.gof.factory;

public class Cycle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Cycle::draw() method");
    }
}
