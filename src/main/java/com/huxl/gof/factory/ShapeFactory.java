package com.huxl.gof.factory;

public class ShapeFactory {

    public Shape getSape(String shapeType){
        if (null == shapeType) {
            return null;
        }

        if (shapeType.equalsIgnoreCase("CYCLE")) {
            return new Cycle();
        }else if (shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if (shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }

        return null;


    }
}
