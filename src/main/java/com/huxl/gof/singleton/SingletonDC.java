package com.huxl.gof.singleton;

/**
 * @author huxl
 * 双重检查锁
 * @createDate 2017/10/27 14:23
 */
public class SingletonDC {
    private SingletonDC(){};
    //懒汉式
    private volatile static SingletonDC instance = null;

    public static synchronized SingletonDC getInstance() {
        if (instance == null ) {
            synchronized (SingletonDC.class) {
                instance = new SingletonDC();
            }
        }

        return instance;
    }

}
