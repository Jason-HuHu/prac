package com.huxl.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author huxl
 * @createDate 2018/2/7 11:51
 * 在完成某些运算时，只有其他所有线程的运算全部完成，当前运算才能继续执行
 *
 * 例子：统计10个线程并发执行的时间 可以使用闭锁实现
 */
public class TestCountDownLatch {
    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch(10);
        long start =  System.currentTimeMillis();
        LatchDemo ld = new LatchDemo(latch);
        for (int i = 0; i < 10; i++) {
            new Thread(ld).start();
        }
        long end =  System.currentTimeMillis();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("耗时----------------------------------------------------------：" + (end - start) + "ms");

    }
}

class LatchDemo implements Runnable{

    private CountDownLatch latch;

    LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        //计算50000以内的偶数
        try {
            for (int i = 0;i < 500; i++) {
                if ((i % 2) == 0) {
                    System.out.println(i);
                }
            }
            System.out.println(Thread.currentThread().getName() +  "线程执行完毕");

        } finally {
            latch.countDown();
        }

    }
}

class Test {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
