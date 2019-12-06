package com.huxl.java8.chapter11;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.util.Calendar;
import java.util.Date;

/**
 * JDK1.8 中的时间API
 * @author huxl
 * @since 2019/12/6-11:52
 */
public class Chapter11Demo {

    public static void main(String[] args) {
        Date date = new Date(114,2,18);
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        System.out.println(time + "\n" + calendar);

        //两个线程如果用同一个DateFormat 解析日期，可能出现无法预期的结果
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        Instant instant = Instant.now();

        LocalDateTime localDateTime = LocalDateTime.now();

        localDate.with(ChronoField.ALIGNED_WEEK_OF_MONTH,1);

        System.out.println("localDate:" + localDate);
        System.out.println("localTime:" + localTime);
        System.out.println("instant:" + instant);
        System.out.println("localDateTime:" + localDateTime);

        int year = localDate.getYear();
        int monthValue = localDate.getMonthValue();
        Month month = localDate.getMonth();
    }
}
