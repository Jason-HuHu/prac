package com.huxl.interview;

import java.util.Scanner;

/**
 * TODO..
 *
 * @author huxingl
 * @since 2018/8/30 18:18
 */


public class TestLong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        String ss = Long.toString(num);
        char[] ch = ss.toCharArray();
        int j=ch.length;
    
        System.out.print(ch[j-7]);
        System.out.print(ch[j-6]);
        System.out.print(ch[j-5]);
        System.out.print(ch[j-4]);
        byte a = 126;
        a += 1;
        a += 0;
    
    }
}
