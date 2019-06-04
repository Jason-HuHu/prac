package com.huxl.base;

/**
 * 小米武汉面试
 *
 * @author huxl
 */
public class IntegerBase {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 1;
        System.out.println(a == b);
        System.out.println(a.equals(b));

        String s1 = "A";
        String s2 = "A";
        String s3 = new String("A");

        System.out.println(s1 == s2 );
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));

        /**
         * 交替打印机构
         */
    }
}
