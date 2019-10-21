package com.huxl.java8.chapter1;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Chapter1Demo {
    public static void main(String[] args) {
        //Collections 和 Streams之间做转换
        //外部迭代 -- 内部迭代
        //Collection 和 Stream
        //默认方法，java8在接口声明中用default关键字
        //Optional
        //模式匹配
        //允许并行处理

    }

    private void method(){

        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        //编写函数作为一个一等值来传递个程序
        hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
        /*
           什么是谓词?
           谓词(predicate):在数学中常常用来表达代表一个类似函数的东西，接受一个参数值，返回true或者false
         */
        //匿名Lambda
        /*
            filterApples(inventory,(Apple a)->a.getWeight() > 150);
         */
    }
}

class Apple{
    private String color;
    private int weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }
    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight() > 150;
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result= new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
