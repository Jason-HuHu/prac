package com.huxl.gof.singleton;

/**
 * 线程安全饿汉式
 * @author huxl
 * @createDate 2017/10/27 14:23
 */
public class Singleton2 {
    private Singleton2(){};
    //懒汉式
    private static Singleton2 instance = new Singleton2();

    public static synchronized Singleton2 getInstance() {

        return instance;
    }

}
