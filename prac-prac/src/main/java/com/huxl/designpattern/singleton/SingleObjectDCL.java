package com.huxl.designpattern.singleton;

/**
 * @author huxl
 * @since 2018/3/22 10:51
 * 双检锁（double-checked locking）
 * 多线程的情况下能够保持高性能
 */
public class SingleObjectDCL {
    private volatile static SingleObjectDCL instance;
    //构造函数私有化，就不会被实例化
    private SingleObjectDCL() {}
    //获取可用的唯一对象
    public static  SingleObjectDCL getInstance() {
        if (instance == null) {
            synchronized (SingleObjectDCL.class) {
                if (instance == null) {
                    instance = new SingleObjectDCL();
                }
            }
        }

        return instance;
    }
}
