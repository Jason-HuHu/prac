package com.huxl.prac;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Main {
    /**
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        testTrans();
    }

    /**
     *
     */
    public static void testTrans() {
        Integer b = new Integer(1);
        int a = 0;
        String str = Integer.toString(a);
        String strb = b + "";
        String strc = String.valueOf(str);
        System.out.println(strc);
    }

    /**
     * 测试Lambda表达式
     */
//    public void testLambda() {
//        int a, b;
//        //(int d, int c) -> d + c;\
//        () -> { System.out.println("Hello Lambda!"); }
//
//        Object o = (Runnable)()->{System.out.println("aaaa");}
//    }

    Thread oldSchool = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("This is from an anonymous class");
        }
    });

    Thread lambdaTest = new Thread(() -> {
        System.out.println("this is Lambda exp");
    });
    /**
     * 学习Lambda表达式
     * @param a 参数1
     * @param b 参数2
     * @return int 和
     */
    public int add(int a, int b) {

        List<Integer> list;
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        for (Integer c : list) {
            System.out.println(c);
        }

        list.forEach(d -> {
            System.out.println(d);
        });

        list.stream().filter(c -> c.equals(1)).forEach(c -> {
            System.out.println(c);
        });
        return a + b;
    }
}
