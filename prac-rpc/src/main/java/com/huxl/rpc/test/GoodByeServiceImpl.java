package com.huxl.rpc.test;

/**
 * @author huxl
 * @createDate 2018/1/10 8:57
 */
public class GoodByeServiceImpl implements GoodByeService {
    @Override
    public String  byebye(String name) {
       return  "Bye" + name;
    }
}
