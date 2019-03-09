package com.huxl.gof.singleton;

/**
 * 静态内部类
 */
public class SingletonStatic {

    private SingletonStatic(){}
    private static class SingletonHolder{
        private static final SingletonStatic INSTANCE = new SingletonStatic();
     }

     public static final SingletonStatic getInstance(){
        return SingletonHolder.INSTANCE;
     }

}
