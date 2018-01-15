package com.huxl.rpc.test.consumer;

import com.huxl.rpc.framework.RpcFramework;
import com.huxl.rpc.test.GoodByeService;
import com.huxl.rpc.test.HelloServrice;

/**
 * @author huxl
 * @createDate 2018/1/9 19:30
 */
public class RpcConsumer {
    public static void main(String [] args) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HelloServrice servrice = RpcFramework.refer(HelloServrice.class,"132.126.3.122", 8888);
                    for (int i = 0; i < 10; i++) {
                        String hello = servrice.haha("world " + i);
                        System.out.println(hello);
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
               try {
                   GoodByeService service2 = RpcFramework.refer(GoodByeService.class,"132.126.3.122",8889);
                   for (int i = 0; i < 10; i++) {
                       String bye = service2.byebye("name" + i);
                       System.out.println(bye);
                       Thread.sleep(1000);
                   }
               }catch (Exception e) {
                   e.printStackTrace();
               }
            }
        }).start();

    }
}
