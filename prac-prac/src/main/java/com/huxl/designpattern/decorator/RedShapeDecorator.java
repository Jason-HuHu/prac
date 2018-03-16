package com.huxl.designpattern.decorator;


/**
 * 扩展了AbstractShapeDecorator类的实体装饰类
 * @author huxl
 * @createDate 2018/3/16 14:14
 */
public class RedShapeDecorator extends AbstractShapeDecorator {
    public RedShapeDecorator(IShape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(IShape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}
