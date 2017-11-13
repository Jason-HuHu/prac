package com.huxl.gof;

/**
 * @author huxl
 * @createDate 2017/10/27 14:23
 */
public class Singleton {
    private Singleton(){};


    //懒汉式
    private static Singleton singleton = null;

    //静态工厂方法
    public synchronized Singleton getInstance() {
        if (singleton == null ) {
            singleton = new Singleton();
        }
        return singleton;
    }

    //饿汉式
    private final static Singleton singleton1 = new Singleton();

    public synchronized  Singleton getInstance1(){
        return singleton1;
    }

}
