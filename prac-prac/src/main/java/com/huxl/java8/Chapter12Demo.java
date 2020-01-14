package com.huxl.java8;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Comparator;

/**
 * 日期API
 * @author huxl
 * @since 2019/12/19-14:14
 */
public class Chapter12Demo {
    public static void main(String[] args) {

        //java8获取本月最后一天
        LocalDate localDate = LocalDate.now();
        LocalDate lastDay = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);


        String strValue  = null;

        if ((strValue = "111") == null) {
            strValue = "x";
        }

        System.out.println(strValue);

    }
}
