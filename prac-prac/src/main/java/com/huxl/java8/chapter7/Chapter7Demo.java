package com.huxl.java8.chapter7;

import java.util.function.Function;

/**
 * 并行数据处理
 * @author huxl
 * @since 2019/11/22-20:08
 */
public class Chapter7Demo {

    public static long measureSumperf(Function<Long,Long> adder,long n) {
        long featest = Long.MAX_VALUE;
        for (int i = 0;  i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime())  - start /100_000_000;
            System.out.println("Result:" + sum);
            if (duration  < featest) {
                featest = duration;
            }
        }
        return featest;
    }

    public static void main(String[] args) {
        System.out.println("Sequential sum done in :");
    }
}
