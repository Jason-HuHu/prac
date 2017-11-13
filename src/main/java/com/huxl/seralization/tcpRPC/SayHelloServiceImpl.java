package com.huxl.seralization.tcpRPC;

/**
 * @author huxl
 * @createDate 2017/10/30 9:48
 */
public class SayHelloServiceImpl implements SayHelloService {
    @Override
    public String sayHello(String helloArg) {
        if (helloArg.equals("hello")) {
            System.out.println("Hello RPC");
            return "hello RPC";
        }else {
            return "byebye";
        }
    }
}
