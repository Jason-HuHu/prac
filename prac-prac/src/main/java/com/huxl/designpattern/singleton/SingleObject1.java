package com.huxl.designpattern.singleton;

/**
 * @author huxl
 * @since 2018/3/22 10:51
 * 懒汉式   -- 线程不安全的
 */
public class SingleObject1 {
    private static SingleObject1 instance;
    //构造函数私有化，就不会被实例化
    private SingleObject1() {}
    //获取可用的唯一对象
    public static SingleObject1 getInstance() {
        if (instance == null) {
            instance = new SingleObject1();
        }
        return instance;
    }
}
