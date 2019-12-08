package com.huxl.java8.chapter6;


import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Chapter6Demo {
    public static void main(String[] args) {

        /**
         * 总结
         * collect是一个终端操作，它接收的参数是将流中元素累积到汇总结果的各种方式
         * 预定义收集器包括将流元素规约和汇总到一个 值，例如计算最大值、最小值、平均值
         * 预定义收集器可以用groupingBy对流中元素进行分组，或用partitioningBy进行分区
         * 收集器可以高效地复合起来，进行多级多组、分区和归约
         * 可以实现Collector接口中定义的方法来开发自己的收集器
         */
        List<Dish> menu = Arrays.asList(
                new Dish(true,Type.META,1,"1"),
                new Dish(true,Type.META,1,"2")
        );
        //规约和汇总
        /**
         * 利用收集器为流元素数值属性，求最大值，最小值，和
         */
        double avgCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        IntSummaryStatistics intSummaryStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(intSummaryStatistics);

        int totalCalories = menu.stream().collect(
                Collectors.reducing(0,Dish::getCalories,(i,j)->i+j)
        );


    }

    private static void introduct(){
        //函数式编程与指令式编程的区别：只用关心“做什么”，而不用关心“怎么做”
    }

    public boolean isPrime(int candidate) {
        return IntStream.range(2,candidate).noneMatch(i -> candidate % i == 0);
    }
    public boolean isPrime2(int candidate) {
        int candidateRoot = (int)Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2,candidateRoot)
                .noneMatch(i->candidate % i == 0);
    }

    public Map<Boolean,List<Integer>> partionPrimes(int n) {
        return IntStream.rangeClosed(2,n).boxed().collect(Collectors.partitioningBy(candidate ->isPrime2(candidate)));
    }


    public static boolean isPrime(List<Integer> primes,int candidate) {
        return primes.stream().noneMatch(i->candidate %i == 0);
    }

    //给定一个排序列表和一个谓词
    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            //检查列表中的当前项目是否满足谓词
            if (!p.test(item)) {
                //如果不满足，返回该项目之前的前缀子列表
                return list.subList(0,i);
            }
            i++;
        }
        //列表中所有项目都满足谓词，因此返回列表本身
        return list;

    }
}


class Dish {
    private final boolean vegetarian;
    private final Type type;
    private final int calories;

    private final String name;

    Dish(boolean vegetarian, Type type, int calories, String name) {
        this.vegetarian = vegetarian;
        this.type = type;
        this.calories = calories;
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public Type getType() {
        return type;
    }
}
enum Type{
    /**
     * 肉
     */
    META,
    /**
     * 鱼
     */
    FISH,
    /**
     * 其他
     */
    OTHER
}



