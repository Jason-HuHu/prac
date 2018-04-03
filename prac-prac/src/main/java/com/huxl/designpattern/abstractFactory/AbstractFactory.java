package com.huxl.designpattern.abstractFactory;

import com.huxl.designpattern.abstractFactory.color.Color;
import com.huxl.designpattern.abstractFactory.shape.Shape;

/**
 * @author huxl
 * @createDate 2018/3/21 18:44
 */
public abstract class AbstractFactory {
    abstract Shape getShape(String shape);
    abstract Color getColor(String color);

}
