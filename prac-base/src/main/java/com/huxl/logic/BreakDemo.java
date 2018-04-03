package com.huxl.logic;

/**
 * TODO...
 *
 * @author huxl
 * @since 2018/3/26 11:12
 */
public class BreakDemo {
    public static void main(String[] args) {
        testBreak();
    }
    private static void testBreak() {
        for (int i = 0; i < 10; i++) {
            if ((i % 2) == 0) {
                System.out.println("这是在if语句中 [i]:" + i);
                continue;
            }
            System.out.println("这是在for语句中;[i]" + i);
        }
    }
}
