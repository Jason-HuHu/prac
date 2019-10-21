package com.huxl.java8.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 通过行为参数传递代码
 * 行为参数化
 * 匿名类
 * Lambda表达式
 */
public class Chapter2Demo {
    public static void main(String[] args) {
        System.out.println("第二章 通过行为参数化传递代码");
        //实例：Comparator、Runnable、GUI事件处理
        System.out.println("行为参数化：一个方法接受多个不同的行为，并在内部使用他们，完成不同行为的能力");
        System.out.println("行为参数化可以让代码更好的适应需求的变化，减轻未来工作量");
        System.out.println("传递代码就是将新的行为作为参数传递给代码，但是在Java8之前实现起来很啰嗦，为接口声明许多只用一次的实体类而造成啰嗦的代码，Java8之前可以用匿名内部类来姐姐");
        System.out.println("JavaAPI中包含很多可以用不同行为进行参数化的方法，包括排序/线程和GUI等");
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)){
                result.add(e);
            }
        }
        return result;
    }
}
