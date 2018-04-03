package com.huxl.designpattern.bridge;

/**
 * TODO...
 *
 * @author huxl
 * @since 2018/3/22 17:39
 */
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
