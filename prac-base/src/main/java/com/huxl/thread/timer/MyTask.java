package com.huxl.thread.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时任务
 *
 * @author huxl
 */
public class MyTask extends TimerTask {
    private Timer timer;
    @Override
    public void run() {
        System.out.println(MyTask.class.getName() + "开始执行");
        if (timer != null) {
            System.out.println("结束定时器");
            timer.cancel();
        }
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
