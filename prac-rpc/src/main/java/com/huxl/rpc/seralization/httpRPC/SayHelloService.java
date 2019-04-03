package com.huxl.rpc.seralization.httpRPC;

import java.util.Map;

/**
 * @author huxl
 * @createDate 2017/10/30 9:47
 */
public class SayHelloService implements BaseService{

    @Override
    public Object execute(Map<String, Object> args) {
        //request.getParameterMap()取出来的时候为array
        String[] helloArg = (String[]) args.get("arg1");
        if ("hello".equals(helloArg[0])) {
            return "hello";
        }else {
            return "byebye";
        }

    }
}
