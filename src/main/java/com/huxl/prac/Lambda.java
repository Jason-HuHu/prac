package com.huxl.prac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 学习Lambda
 */
public class Lambda {
    public void distinctPrimary(String... numbers) {
        List<String> i = Arrays.asList(numbers);
        //静态方法引用
        Comparator<Integer> c1 = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> c2 = Integer :: compare;

        //实例方法引用

    }
}
