package com.huxl.rpc.seralization.loadBalancing;

/**
 * @author huxl
 * @createDate 2017/10/31 14:39
 */
public class ThreadA implements Runnable {
    @Override
    public void run() {
        RoundRobin.testRoundRobin();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("current thread name:" + Thread.currentThread().getName());
    }
}
