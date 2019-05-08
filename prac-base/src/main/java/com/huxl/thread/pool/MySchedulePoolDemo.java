package com.huxl.thread.pool;

import java.util.concurrent.*;

/**
 * 定时执行的线程池
 *
 * @author huxl
 */
public class MySchedulePoolDemo {

    public static void main(String[] args) {
//        ThreadFactory threadFactory = new
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        long delay = 10;
        executorService.schedule(new MyTask(),delay, TimeUnit.SECONDS);
        executorService.shutdown();
    }
}
