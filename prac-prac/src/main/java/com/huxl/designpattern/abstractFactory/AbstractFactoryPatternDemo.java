package com.huxl.designpattern.abstractFactory;

import com.huxl.designpattern.abstractFactory.color.Color;
import com.huxl.designpattern.abstractFactory.shape.Shape;

/**
 * @author huxl
 * @createDate 2018/3/21 19:08
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        //获取形状工厂
        AbstractFactory shapeFactory =  FactoryProducer.getFactory("SHAPE");
        //获取形状为circle的对象
        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();

        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        Color color = colorFactory.getColor("RED");
        color.fill();
    }
}
