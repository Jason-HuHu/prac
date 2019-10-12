package com.huxl.interview.object;

public class WaitThread implements Runnable {

    private Object object;

    public WaitThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("当前线程睡眠1s");
                Thread.sleep(1000);
                System.out.println("当前线程等待被唤醒");
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
