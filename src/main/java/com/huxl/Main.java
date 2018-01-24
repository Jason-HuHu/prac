package com.huxl;

import com.huxl.value.Person;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author huxl
 * @createDate 2017/11/3 16:06
 */
public class Main {
    private static int CUSTITEM_LENGTH = 16;
    public static void main(String[] args) {
        Date after = addDays(new Date(),15);
        Date before = addDays(new Date(),-15);
        SimpleDateFormat format = new SimpleDateFormat();

//        System.out.println( format.format(before));
        String code = new Main().testParse("!TS");
//        System.out.println(code);
//        testCharStr();
        Map map = new HashMap();
        map.put(null,"11");
        map.put(null,"12");
        System.out.println(map.get(null));
    }


    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }


    public String testParse(String rule) {
        if (rule.equals("0")) {
            return "0000000000000000";
        } else if (rule.equals("1")) {
            return "****************";
        }

        String[] codes = rule.split(":");
        //生成掩码
        char[] maskCode = new char[CUSTITEM_LENGTH];
        for (int i = 0; i < CUSTITEM_LENGTH; i++) {
            maskCode[i] = '*';
        }

        for (int i = 0; i < codes.length; i++) {
            if (codes[i].length() < 2) {
                continue;
            }

            if (codes[i].charAt(0) == '!') {
                String code = codes[i].substring(1, codes[i].length());
                maskCode[getLocation(code)] = '0';
            } else {
                maskCode[getLocation(codes[i])] = '1';
            }
        }
        return new String(maskCode);
    }

    private static int getLocation(String code) {
        if ("TS".equals(code)) {
            return 0;
        }else {
            return 1;
        }
    }

    public static void testCharStr() {
        String str = "0000001";
        char[] charArr = str.toCharArray();
        char[] a = {'0','1'};
        String c = new String(a);
        String b = "0";
        char d = a[0];
        System.out.println('0' == d);
        System.out.println(charArr[0] == d);
    }
}
