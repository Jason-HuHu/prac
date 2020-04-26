package com.huxl.juc;

public class DeadLock {

    private static String a = "a";
    private static String b = "b";

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (a){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                   System.out.println(Thread.currentThread().getName());
               }
            }
        },"t1").start();

        new Thread(() -> {
            synchronized (b){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        },"t2").start();
        System.out.println(a);
        System.out.println(b);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
