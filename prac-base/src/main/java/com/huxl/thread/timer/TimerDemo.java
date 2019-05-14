package com.huxl.thread.timer;

import sun.util.resources.cldr.ru.TimeZoneNames_ru;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器
 *
 * @author huxl
 */
public class TimerDemo {

    public static void main(String[] args) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-05-08 21:18:50");

        Timer timer = new Timer();

//        timer.schedule(new TimerTask() {
//
//            @Override
//            public void run() {
//                System.out.println("开始执行" + "time" + new Date());
//            }
//        },date);
        MyTask myTask = new MyTask();
        myTask.setTimer(timer);
        timer.schedule(myTask,date);


    }
}
