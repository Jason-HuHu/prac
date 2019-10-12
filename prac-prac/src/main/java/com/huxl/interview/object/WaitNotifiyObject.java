package com.huxl.interview.object;

public class WaitNotifiyObject {


    public static void main(String[] args) {
         Object obj = new Object();

         Thread waitThread = new Thread(new WaitThread(obj));
         Thread notifyThread = new Thread(new NotifyThread(obj));

         waitThread.start();
         notifyThread.start();

    }
}
