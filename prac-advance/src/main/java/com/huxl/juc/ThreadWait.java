package com.huxl.juc;

import java.util.Scanner;

public class ThreadWait {

    public static void main(String[] args) {
        Object obj = new Object();
        Thread t1 = new Thread(() -> {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("循环外中断了");

            }
            try {
                Scanner sc = new Scanner(System.in);
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                    System.out.println("线程中断了：" + Thread.currentThread().isInterrupted());

                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("线程中断了");
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        t1.stop();

        System.out.println("线程会自己中断吗");
    }
}
