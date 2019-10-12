package com.huxl.interview.object.producerandconsumer;

public class Producer extends Thread {

    //每次生产的数量
    private int num;

    //所属仓库
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            producer(num);

        }
    }

    private void producer(int num){
        storage.produce(num);
    }
}
