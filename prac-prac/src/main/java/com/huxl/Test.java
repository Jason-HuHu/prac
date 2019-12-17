package com.huxl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 1 3 5 6,2 3 4 5
 * @author huxingl
 * @since 2018/8/30 17:48
 */


public class Test {
    public static void main(String[] args) {
       String s =  sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
       System.setProperty("java.lang.Integer.IntegerCache.high","128");
        System.out.println(s);
       int a = 251;
       Integer b = 128;
        System.out.println((a == b));
    }

}
