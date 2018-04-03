package com.huxl.designpattern.prototype;

import java.util.Hashtable;

/**
 * 从数据库中获取实体类，并存储在hashTable中
 *
 * @author huxl
 * @since 2018/3/22 17:02
 */
public class ShapeCache {
    private static Hashtable<String,Shape> shapeMap = new Hashtable<>();
    public static Shape getShape(String shapeId){
        Shape cachedShape = shapeMap.get(shapeId);
            return (Shape) cachedShape.clone();
    }

    //加载形状对象到shapeMap
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        shapeMap.put(rectangle.getId(),rectangle);

        Square square = new Square();
        square.setId("3");
        shapeMap.put(square.getId(),square);
    }
}
