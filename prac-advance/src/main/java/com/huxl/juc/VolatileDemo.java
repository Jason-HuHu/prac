package com.huxl.juc;

public class VolatileDemo {

    public static volatile boolean flag = false;

    public static volatile int count = 0;
    public static final int size = 10*10000;

    public static void main(String[] args) throws InterruptedException {
        //内存可见性问题
        //volatile1();
        //并不是轻量级的synchronized
        //volatile2();

    }

    private static void volatile2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                synchronized (VolatileDemo.class) {
                    System.out.println("t1..");
                    count++;
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                synchronized (VolatileDemo.class) {
                    System.out.println("t2__");
                    count--;
                }
            }
        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }

    private static void volatile1() {
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            }catch (Exception e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("flag修改为true");
        }).start();
        while (true) {
            if (flag) {
                System.out.println("flag变为true");
                break;
            }
        }
    }
}
