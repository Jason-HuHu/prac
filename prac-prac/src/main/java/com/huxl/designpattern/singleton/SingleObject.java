package com.huxl.designpattern.singleton;

/**
 * @author huxl
 * @createDate 2018/3/22 10:51
 * 饿汉式
 */
public class SingleObject {
    private static  SingleObject instance = new SingleObject();
    //构造函数私有化，就不会被实例化
    private SingleObject() {}
    //获取可用的唯一对象
    public static SingleObject getInstance() {
        return instance;
    }
}
