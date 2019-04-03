package com.huxl.thread;

/**
 * @author huxl
 * @createDate 2017/11/28 11:18
 */
public class TestNum {
    //通过匿名内部类覆盖ThreadLocal的initialValue方法，设置默认值
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }
    private  int a;
    public int getNextA() {
        setA(getA() + 1);
        return getA();
    }

    public TestNum(){}
    public TestNum(int a) {
        this.a = a;
    }

    public  int getA() {
        return a;
    }

    public  void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args) throws InterruptedException {
        TestNum tn = new TestNum(2);
        TestClient tc1 = new TestClient(tn);
        TestClient tc2 = new TestClient(tn);
        TestClient tc3 = new TestClient(tn);
        TestClient tc4 = new TestClient(tn);
        tc1.start();
        Thread.sleep(1000);
        System.out.println("---------------------刚睡醒");
        tc2.start();
        Thread.sleep(1000);
        System.out.println("---------------------刚睡醒");
        tc3.start();
        Thread.sleep(1000);
        System.out.println("---------------------刚睡醒");
        tc4.start();
        Thread.sleep(1000);
        System.out.println("---------------------刚睡醒");



        System.out.println("main[" + tn.getNextA() + "]" + Thread.currentThread().getName());

    }


    private static class TestClient extends Thread {
        private TestNum testNum;
        public TestClient(TestNum testNum) {
            this.testNum = testNum;
        }
        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
//                System.out.println("thread[" + Thread.currentThread().getName() + "]--->sn[" +
//                        testNum.getNextNum() +"]");
//                System.out.println("thread[" + Thread.currentThread().getName() +"]--->next a[" +
//                       testNum.getNextA()   + "]--------[" + testNum.getA() +"]---num["+ testNum.getNextNum()+ "]");
                System.out.println("thread[" + Thread.currentThread().getName() +"]--->next a[" +
                       testNum.getNextA()   + "]--------[" + testNum.getA() +"]---num["+ testNum.getNextNum()+ "]");

            }
        }
    }
}
