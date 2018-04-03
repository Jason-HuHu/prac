package com.huxl.designpattern.abstractFactory;

import com.huxl.designpattern.abstractFactory.color.Color;
import com.huxl.designpattern.abstractFactory.shape.Circle;
import com.huxl.designpattern.abstractFactory.shape.Rectangle;
import com.huxl.designpattern.abstractFactory.shape.Shape;
import com.huxl.designpattern.abstractFactory.shape.Square;


/**
 * @author huxl
 * @createDate 2018/3/21 18:46
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    Shape getShape(String shape) {
        if (shape == null) {
            return null;
        }
        if ("CIRCLE".equals(shape)) {
            return new Circle();
        } else if ("RECTANGLE".equals(shape)) {
            return new Rectangle();
        } else if ("SQUARE".equals(shape)) {
            return new Square();
        }

       throw new RuntimeException("请输入合适的形状 shape" + shape);
    }


    @Override
    Color getColor(String color) {
        return null;
    }
}
