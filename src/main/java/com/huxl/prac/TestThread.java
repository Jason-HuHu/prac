package com.huxl.prac;

public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        Runnable runer = new Runnable() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(runer);
            System.out.print(i + ":");
            t.sleep(3000);
            t.start();

        }
        System.out.println("bar");
    }
}
