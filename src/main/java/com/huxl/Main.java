package com.huxl;

import com.huxl.value.Person;
import org.apache.commons.lang3.StringUtils;
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
//        String code = new Main().testParse("!TS");
//        System.out.println(code);
//        testCharStr();
        Map map = new HashMap();
        map.put(null,"11");
        map.put(null,"12");
//        System.out.println(map.get(null));

//        System.out.println(Integer.reverse(2));

//    testLongToInt();
//    testRegex();
//        testStrCount();
//        testUnicode();
//        System.out.println(getUnicode("|"));

//        testHex();
        Integer b  = 23;
        testStringChange(b);
        System.out.println(b);
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

    public static void testLongToInt() {
        long a = 1000L;
        int b = 100;
        System.out.println(b - a);
        add((int) a);
    }
    public static void add(Integer a) {
        System.out.println(a);
    }

    public static void testRegex(){
        String str ="  \n\t dddd\n" + "ddd\nddsadasda\r" + "dds\tada" + "\t";

        str = StringUtils.replacePattern(str.trim(),"[\t|\r|\n]","");
        System.out.println(str);
    }

    //String 中的count是怎么计算的？
    public static void testStrCount(){
        String str = new String("ssssffff");
        str.intern();
        boolean empty = "".isEmpty();
        String a = "123456";
        System.out.println(str + a) ;
        System.out.println(empty) ;
    }

    public static void testUnicode(){
        String s = "丨";
        char c = '丨';
        System.out.println(Integer.toHexString(c));
        System.out.println(s.toCharArray());
    }

    public static String getUnicode(String source){
        String returnUniCode=null;
        String uniCodeTemp=null;
        for(int i=0;i<source.length();i++){
            uniCodeTemp = "\t" + Long.toHexString((int)source.charAt(i));//使用char类的charAt()的方法
            returnUniCode=returnUniCode==null?uniCodeTemp:returnUniCode+uniCodeTemp;
        }
        System.out.print(source +" 's unicode = "+returnUniCode);
        return returnUniCode;//返回一个字符的unicode的编码值
    }

    public static  void testHex() {
        StringBuilder msgHead = new StringBuilder();

        msgHead.append("\\x04").append("\\x04").append("\\x04").append("\\x04");
        String str =  "\\x04";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(Integer.toHexString(chars[i]));
        }
        System.out.println();
        System.out.println(String.valueOf(msgHead));
    }

    private static void testStringChange(Integer a){
        a = 1;
    }
}
