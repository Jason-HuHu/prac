package com.huxl.designpattern.decorator;

/**
 * 装饰器模式允许向一个现有的对象添加新的功能，同时有不改变其结构，作为一个现有类的一个包装
 *
 * 动态的给一个对象添加一些额外的职责，装饰模式比生成子类的方式更为灵活
 *
 * @author huxl
 * @createDate 2018/3/16 14:19
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        IShape circle = new Circle();
        IShape redCircle = new RedShapeDecorator(new Circle());
        IShape redRectanger = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border!");
        circle.draw();

        System.out.println("Circle with red border!");
        redCircle.draw();

        System.out.println("Rectanger with red border!");
        redRectanger.draw();
    }
}
