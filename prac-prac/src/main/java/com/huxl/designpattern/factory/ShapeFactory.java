package com.huxl.designpattern.factory;

/**
 * @author huxl
 * @createDate 2018/3/21 17:10
 */
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if ("CIRCLE".equals(shapeType)) {
            return new Circle();
        } else if ("RECTANGLE".equals(shapeType)) {
            return new Rectangle();
        } else if ("SQUARE".equals(shapeType)) {
            return new Square();
        }

        return null;
    }
}
