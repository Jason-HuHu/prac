package com.huxl.interview.object.producerandconsumer;

import java.util.LinkedList;
import java.util.List;

public class SZStorage implements Storage {
    /**
     * 仓库最大容量
     */
    private final int MAX_SIZE = 100;

    /**
     * 仓库
     */
    private LinkedList<Object> list = new LinkedList<>();

    @Override
    public void produce(int num) {
        synchronized (list) {
            //仓库剩余容量不足，暂停生产
            while (list.size() + num > MAX_SIZE) {
                System.out.println("<"+ Thread.currentThread().getName()+">[要生产的数量]=" + num + ";[库存]:" + list.size());
                System.out.println("<"+ Thread.currentThread().getName()+">暂停生产");
                try {
                    list.wait();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int i=0;i<num;i++) {
                list.push(new Object());
            }
            System.out.println("<"+ Thread.currentThread().getName()+">生产" + num + "件商品后，库存：" + list.size());
            list.notifyAll();

        }
    }

    @Override
    public void consume(int num) {
        synchronized (list) {
            //不满足消费条件
            while (num > list.size()) {
                System.out.println("<"+ Thread.currentThread().getName()+">需求量：" + num + ",实际库存：" + list.size());
                System.out.println("<"+ Thread.currentThread().getName()+">没有足够的库存!");

                try {
                    System.out.println("<"+ Thread.currentThread().getName()+">begin wait");
                    list.wait();
                    System.out.println("<"+ Thread.currentThread().getName()+">end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            //满足条件后再消费
            for (int i=0;i< num;i++) {
                list.remove();
            }

            System.out.println("<"+ Thread.currentThread().getName()+">消费：" + num + "个，现在库存：" + list.size());
            //通知生产
            System.out.println("<"+ Thread.currentThread().getName()+">notify begin");
            list.notifyAll();
            System.out.println("<"+ Thread.currentThread().getName()+">notify end");

        }
    }
}
