package com.huxl.classloader;

import java.lang.reflect.Method;

/**
 * @author huxl
 * @createDate 2018/3/16 17:26
 */
public class ClassLoaderDemo {
    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("d:/test");
        Class clazz = myClassLoader.loadClass("com.huxl.classloader.ClassLoaderDemo");
        Object obj = clazz.newInstance();
        Method helllMethod = clazz.getDeclaredMethod("hello",null);

    }
}
