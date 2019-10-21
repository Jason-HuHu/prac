package com.huxl.java8.chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Chapter3Demo {
    public static void main(String[] args) throws IOException {
        System.out.println("第三章 Lambda表达式");
        //方法引用(method reference)
        //匿名 函数 传递 简洁
        // 参数列表 箭头 方法主体 (Apple a1,Apple a2) -> {a1.getWeight().compareTo(a2.getWeight())}

        /*
            可以使用Lambda表达式的地方
              1.函数式接口 ：只定义一个抽象方法的接口
              2.函数描述符：函数式接口的抽象方法就是Lambda表达式的签名，这种抽象方法就是函数描述符 ()->{}; ()->String;()->boolean;
              3.环绕执行

              Lambda表达式是如何做类型检查的？
              @FunctionalInterface是干啥的？不是必须的，但是一旦标记了该注解，表明该接口会设计成一个函数式接口
         */
        Runnable r1 = ()-> System.out.println("Hello World!");
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("H"));

        //正常读取一行:
        String oneLine = processFile();
        System.out.println(oneLine);
        oneLine = processFile((br) -> br.readLine());
        System.out.println(oneLine);
        String twoLine = processFile((br)->br.readLine() + br.readLine());
        System.out.println(twoLine);

        //抽象方法的签名可以描述Lambda表达式的签名。函数式接口的抽象方法的签名称为函数描述符

        //Predicate
        //Consumer
        forEach(Arrays.asList(1,2,3,4),(Integer i)-> System.out.println(i));
        forEach(Arrays.asList(1,2,3,4),System.out::println);
        //Function
        List<Integer> l = map(Arrays.asList("lambda","in","action"),(String s)->s.length());
        //method reference 方法引用
        List<Integer> l2 = map(Arrays.asList("lambda","in","action"),String::length);

        //原始类型特化
        IntPredicate evenNumbers = (int i)-> i%2==0;
        evenNumbers.test(1000);
        Predicate<Integer> oddNumbers = (Integer i) -> i%2 ==1;
        oddNumbers.test(1000);

        //Lambdas 和 函数式接口的例子
        /*
            布尔表达式 | (List<String> list) -> list.isEmpty() | Predicate<List<String>>
            创建对象   | ()->new Apple() | Supplier<Apple>
            消费一个对象| (Apple a) -> System.out.println(a.getWeight()) | Consumer<Apple>
            从一个对象中选择 | (Apple a) -> a.getWeight() | Function<String,Integer>或者 ToIntFunction<String>
            或者提取
            合并两个值 | (int a,int b) -> a*b | IntBinaryOperator
            比较两个对象 | (Apple a1,Apple a2) -> a1.getWeight().compareTo(a2.getWeight()) | Comparator<Apple>或者BiFunction<Apple,Apple,Integer>或ToBiFunction<Apple,Apple>
         */

        //!!!!!!!!!!!!!!!!!

        //任何函数式接口都不允许抛出受检查异常(checked Exception) 如果需要lambda表达式来抛出异常1：自定义一个函数式接口，并声明受检查异常，或者把lambda包在try/cache中

    }

    private static void process(Runnable r) {
        r.run();
    }

    private static String processFile() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            return br.readLine();
        }catch (Exception e)  {
            throw new IOException();
        }
    }

    private static String processFile(BufferedReaderProcessor p) throws IOException{
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            return p.process(br);
        }catch (Exception e) {
            throw new IOException();
        }
    }

    private static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
    private static <T,R> List<R> map(List<T> list, Function<T,R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }
}
