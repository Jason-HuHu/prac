package com.huxl.thread;

/**
 * @author huxl
 * @createDate 2017/11/29 17:15
 */
public class TestAtomicDemo {

    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(atomicDemo).start();
        }
    }

    private static class AtomicDemo implements Runnable{
        private int serialNum = 0;

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getSerialNum());

        }
        public int getSerialNum(){
            return serialNum++;
        }
    }
}
