package com.huxl.api;

import java.util.List;

/**
 * TODO..
 *
 * @author huxingl
 * @since 2018/9/27 10:43
 */


public class DemoImpl implements IDemo {
    @Override
    public void testDemo(Integer integer, Long l, String str) {
        System.out.println("str:" + str);
    }
    
    @Override
    public void testDemo(Integer integer, Long l, List list) {
        System.out.println("list:"+list);
    }
    
    @Override
    public void testDemo(Integer integer, Long l, Integer i) {
        System.out.println("i:"+i);
    }
}
