package com.huxl.thread.pool;

import java.util.Date;
import java.util.TimerTask;

/**
 *
 * @author huxl
 */
public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("测试一下线程池调度" + new Date());
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("睡眠10s之后" + new Date());
    }
}
