package com.huxl.designpattern.bridge;

/**
 * TODO...
 *
 * @author huxl
 * @since 2018/3/22 17:42
 */
public class Circle extends Shape {
    protected Circle(DrawAPI drawAPI) {
        super(drawAPI);
    }

    @Override
    public void draw() {
        drawAPI.drawCircle();
    }
}
