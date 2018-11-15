package com.huxl.api;

/**
 * TODO..
 *
 * @author huxingl
 * @since 2018/9/27 10:45
 */


public class DemoMain {
    public static void main(String[] args) {
        IDemo demo = new DemoImpl();
        //编译不通过
//        demo.testDemo(1,2L,null);
    }
}
