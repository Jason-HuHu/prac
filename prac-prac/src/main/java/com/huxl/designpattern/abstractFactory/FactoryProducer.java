package com.huxl.designpattern.abstractFactory;

/**
 * @author huxl
 * @createDate 2018/3/21 19:00
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equals("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equals("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }

}
