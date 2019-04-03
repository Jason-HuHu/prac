package com.huxl.rpc.test;

/**
 * @author huxl
 * @createDate 2018/1/9 19:27
 */
public class HelloServiceImpl implements HelloServrice {
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }

    @Override
    public String haha(String ha) {
        return "HAHA:" + ha;
    }
}
