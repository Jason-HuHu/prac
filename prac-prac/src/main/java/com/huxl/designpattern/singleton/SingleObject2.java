package com.huxl.designpattern.singleton;

/**
 * @author huxl
 * @since 2018/3/22 10:51
 * 懒汉式   -- 线程安全的
 */
public class SingleObject2 {
    private static SingleObject2 instance;
    //构造函数私有化，就不会被实例化
    private SingleObject2() {}
    //获取可用的唯一对象
    public static synchronized SingleObject2 getInstance() {
        if (instance == null) {
            instance = new SingleObject2();
        }
        return instance;
    }
}
