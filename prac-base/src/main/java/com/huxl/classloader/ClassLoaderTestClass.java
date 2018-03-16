package com.huxl.classloader;

/**
 * @author huxl
 * @createDate 2018/3/16 17:02
 */
public class ClassLoaderTestClass {
    public void hello() {
        System.out.println("我是由：" + getClass().getClassLoader().getClass() + "加载的");
    }
}
