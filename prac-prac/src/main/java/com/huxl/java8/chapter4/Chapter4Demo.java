package com.huxl.java8.chapter4;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 引入流
 * 什么是流？
 * 流与集合什么关系？
 * 内部迭代与外部迭代的关系？
 * 中间操作与终端操作？
 * @author huxl
 */
public class Chapter4Demo {

    public static void main(String[] args) {
        //案例1 实现一个从菜单中找出低热量的菜肴名称，并按照卡路里排序的功能
        List<Dish> menu = Arrays.asList(
                new Dish(false, Type.META,800, "pork"),
                new Dish(false,Type.META,700,"beef"),
                new Dish(false,Type.META,400,"chicken"),
                new Dish(true,Type.OTHER,530,"french"),
                new Dish(true,Type.OTHER,350,"rice"),
                new Dish(true,Type.OTHER,120,"season fruit"),
                new Dish(true,Type.OTHER,550,"pizza"),
                new Dish(false,Type.FISH,300,"prawns"),
                new Dish(false,Type.FISH,450,"salmon")
        );
    }

    private List<String> getResultByJava7(List<Dish> menu){
        List<String> sortedDishNames = new ArrayList<>();

        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(),o2.getCalories());
            }
        });
        for (Dish dish : lowCaloricDishes) {
            sortedDishNames.add(dish.getName());
        }

        return sortedDishNames;
    }
    private List<String> getResultByJava8(List<Dish> menu) {
        //并行处理 menu.parallelStream()
        return menu.stream()
                //过滤出热量小于400的
                .filter(d -> d.getCalories() < 400)
                //按热量排序
                .sorted(Comparator.comparing(Dish::getCalories))
                //抽取名称
                .map(Dish::getName)
                //组成列表
                .collect(Collectors.toList());
    }

    private List<String> getThreeHighCaloriesDishName(List<Dish> menu) {
        return menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
    }

}
class Dish{
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