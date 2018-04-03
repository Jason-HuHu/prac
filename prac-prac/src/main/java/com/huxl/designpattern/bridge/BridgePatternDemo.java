package com.huxl.designpattern.bridge;

/**
 * 目的：桥接模式用于将抽象部分与实现部分分离，使他们都可以独立变化
 * 解决问题：在多种可能会变的情况下，用继承会造成类爆炸的问题，扩展起来不够灵活
 *
 *
 * @author huxl
 * @since 2018/3/22 17:24
 */
public class BridgePatternDemo {
    public static void main(String[] args) {

        Shape redCircle = new Circle(new RedCircle());
        Shape greenCircle = new Circle(new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
