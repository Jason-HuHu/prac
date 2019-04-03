package com.huxl.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huxl
 * @createDate 2017/11/17 11:11
 */
public class ThreadTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 100; i++) {
            pool.submit(new MyThread());
        }

        pool.shutdown();
    }
}
