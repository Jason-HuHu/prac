package com.huxl.rpc.test.provider;

import com.huxl.rpc.framework.RpcFramework;
import com.huxl.rpc.test.HelloServiceImpl;
import com.huxl.rpc.test.HelloServrice;

/**
 * @author huxl
 * @createDate 2018/1/9 19:28
 */
public class RpcProvider {
    public static void main(String[] args) throws Exception{
        HelloServrice servrice = new HelloServiceImpl();
        RpcFramework.export(servrice,8888);

    }
}
