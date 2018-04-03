package com.huxl.designpattern.abstractFactory;

import com.huxl.designpattern.abstractFactory.color.Blue;
import com.huxl.designpattern.abstractFactory.color.Color;
import com.huxl.designpattern.abstractFactory.color.Green;
import com.huxl.designpattern.abstractFactory.color.Red;
import com.huxl.designpattern.abstractFactory.shape.Shape;

/**
 * @author huxl
 * @createDate 2018/3/21 18:58
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }
}