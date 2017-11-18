package com.huxl.thread;

/**
 * @author huxl
 * @createDate 2017/11/17 11:12
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行");
    }
}
