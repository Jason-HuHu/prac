package com.huxl.designpattern.observer;

/**
 * 观察者模式
 *
 * 当对象间存在一对多的关系时，可以使用观察者模式，当一个对象被修改时，会自动通知它的依赖对象
 *
 * @author huxl
 * @since 2018/3/22 20:35
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        BinaryObserver binaryObserver = new BinaryObserver(subject);
        OctalObserver octalObserver = new OctalObserver(subject);
        HexaObserver hexaObserver = new HexaObserver(subject);

        System.out.println("First state Change: 15");
        subject.setState(15);
        System.out.println("Second state Change: 20");
        subject.setState(20);

    }
}
