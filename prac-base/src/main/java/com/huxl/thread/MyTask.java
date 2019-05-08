package com.huxl.thread;

/**
 * @author huxl
 * @createDate 2018/1/25 18:54
 */
public class MyTask implements Runnable {
    private int taskNum;
    public MyTask(){}
    public MyTask(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
//        System.out.println("任务开始了 taskNum" + taskNum);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        System.out.println("任务结束了" + taskNum);

    }
}
