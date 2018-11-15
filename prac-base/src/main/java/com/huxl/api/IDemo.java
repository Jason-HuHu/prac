package com.huxl.api;

import java.util.List;

/**
 * TODO..
 *
 * @author huxingl
 * @since 2018/9/27 10:42
 */


public interface IDemo {
    void testDemo(Integer integer,Long l,String str);
    
    void testDemo(Integer integer, Long l, List list);
    
    void testDemo(Integer integer,Long l,Integer i);
}
