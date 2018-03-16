package com.huxl.designpattern.decorator;

/**
 * 实现了Shape接口的抽象类
 * @author huxl
 * @createDate 2018/3/16 12:03
 */
public abstract class AbstractShapeDecorator implements IShape {
    protected IShape decoratedShape;
    public AbstractShapeDecorator(IShape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }
    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
