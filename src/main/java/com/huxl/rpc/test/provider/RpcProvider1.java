package com.huxl.rpc.test.provider;

import com.huxl.rpc.framework.RpcFramework;
import com.huxl.rpc.test.GoodByeService;
import com.huxl.rpc.test.GoodByeServiceImpl;

/**
 * @author huxl
 * @createDate 2018/1/9 19:28
 */
public class RpcProvider1 {
    public static void main(String[] args) throws Exception{
        GoodByeService service2 = new GoodByeServiceImpl();
        RpcFramework.export(service2,8889);
    }
}
