package com.huxl.interview.object.producerandconsumer;

public class Consumer extends Thread {

    private int num;

    private Storage storage;

    public Consumer(Storage storage) {
        this.storage= storage;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void run() {
      while (true) {

          try {
              Thread.sleep(6000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          consume(num);

      }
    }

    private void consume(int num) {
        storage.consume(num);
    }
}
