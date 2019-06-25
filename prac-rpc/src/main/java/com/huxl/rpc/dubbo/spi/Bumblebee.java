package com.huxl.rpc.dubbo.spi;

/**
 *
 * 我是大黄峰
 * @author huxl
 * @since 2019/6/25 19:19
 */
public class Bumblebee implements Robot {
    @Override
    public void sayHello() {
        System.out.println("Hi! I'm Bumblebee!");
    }
}
