package com.huxl.interview.object;

public class NotifyThread implements Runnable {

    private Object object;

    public NotifyThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("唤醒");
                Thread.sleep(2000);
                object.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
