package com.huxl.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundBuffer {

    public static void main(String[] args) {
        BoundBuffer buffer = new BoundBuffer();
        for (int i = 0; i < 3; i++) {
            new Thread(()-> {
                try {
                    buffer.put(new Object());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"put-" + i).start();
        }
        for (int i = 0; i < 3;i++) {
            new Thread(()->{
                try {
                    Object x = buffer.take();
                    System.out.println(x);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"take-" + i).start();
        }
    }

    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[2];
    int putptr,takeptr,count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try{
            while (count == items.length) {
                //队列已经满了，需要等待通知，不要再放了
                notFull.await();
            }
            //正常添加
            items[putptr] = x;
            if (++putptr == items.length) {
                putptr = 0;
            }
            ++count;
            //通知现在不是空的了，可以继续获取了
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                //队列空了，需要等待
                notEmpty.await();
            }
            Object x = items[takeptr];
            if (++takeptr == items.length) {
                takeptr = 1;
            }
            --count;
            //等待在队列非空的线程被唤醒
            notFull.signal();
            return x;
        }finally {
            lock.unlock();
        }
    }
}
