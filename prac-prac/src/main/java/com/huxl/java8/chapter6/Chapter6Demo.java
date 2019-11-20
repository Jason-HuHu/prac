package com.huxl.java8.chapter6;


import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Chapter6Demo {
    public static void main(String[] args) {

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



