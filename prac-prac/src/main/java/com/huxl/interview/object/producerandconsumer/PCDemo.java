package com.huxl.interview.object.producerandconsumer;

public class PCDemo {

    public static void main(String[] args) {
        //仓库
        Storage storage = new SZStorage();

        //生产者
        Producer p1 = new Producer(storage);
        Producer p2 = new Producer(storage);
        Producer p3 = new Producer(storage);
        Producer p4 = new Producer(storage);
        Producer p5 = new Producer(storage);
        Producer p6 = new Producer(storage);

        Consumer c1 = new Consumer(storage);
        Consumer c2 = new Consumer(storage);
        Consumer c3 = new Consumer(storage);
        Consumer c4 = new Consumer(storage);

        //设置生产者和消费者
        p1.setNum(10);
        p2.setNum(10);
        p3.setNum(10);
        p4.setNum(10);
        p5.setNum(10);
        p6.setNum(80);

        c1.setNum(20);
        c2.setNum(30);
        c3.setNum(20);
        c4.setNum(30);

        //开工！
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();

        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}
