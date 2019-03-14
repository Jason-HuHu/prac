package com.huxl.gof.singleton;

/**
 * 线程安全懒汉式
 * @author huxl
 * @createDate 2017/10/27 14:23
 */
public class Singleton {
    private Singleton(){};
    //懒汉式
    private static Singleton singleton = null;

    public static synchronized Singleton getInstance() {
        if (singleton == null ) {
            singleton = new Singleton();
        }
        return singleton;
    }

}
