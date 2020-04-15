package com.huxl.api;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;

public class DateDemo {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.get(Calendar.YEAR);
        cal.get(Calendar.MONTH);//0-11
        cal.get(Calendar.DATE);
        cal.get(Calendar.HOUR_OF_DAY);
        cal.get(Calendar.MINUTE);
        cal.get(Calendar.SECOND);
        //JDK8之后
        LocalDateTime dt = LocalDateTime.now();
        dt.getYear();
        dt.getMonthValue();
        dt.getDayOfMonth();
        dt.getHour();
        dt.getMinute();
        dt.getSecond();
        //获取1970年1月1日0时0分到现在的毫秒数
        cal.getTimeInMillis();
        System.currentTimeMillis();
        Clock.systemDefaultZone().millis();

        //获取当月第一天
        cal.add(Calendar.MONTH,0);
        cal.set(Calendar.DAY_OF_MONTH,1);
        //获取当前月最后一天
        cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        //JDK8
        LocalDate now = LocalDate.now();
        LocalDate first = LocalDate.of(now.getYear(),now.getMonth(),1);
        LocalDate last = now.with(TemporalAdjusters.lastDayOfMonth());

    }
}
