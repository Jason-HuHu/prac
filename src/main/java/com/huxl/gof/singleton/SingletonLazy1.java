package com.huxl.gof.singleton;

/**
 * 线程不安全懒汉式
 * @author huxl
 * @createDate 2017/10/27 14:23
 */
public class SingletonLazy1 {
    private SingletonLazy1(){};
    //懒汉式
    private static SingletonLazy1 singleton = null;

    public static SingletonLazy1 getInstance() {
        if (singleton == null ) {
            singleton = new SingletonLazy1();
        }
        return singleton;
    }

}
