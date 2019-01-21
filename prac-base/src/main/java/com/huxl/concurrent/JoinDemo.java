package com.huxl.concurrent;

/**
 * 线程
 *
 * @author huxingl
 * @since 2018/11/22 14:48
 */


public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println(1);
        });
        
        Thread t2 = new Thread(() -> {
            System.out.println(2);
        });
        Thread t3 = new Thread(() -> {
            System.out.println(3);
        });
        
        t1.start();
        t1.join();
        
        t2.start();
        t2.join();
        
        t3.start();
        t3.join();
    }
}
