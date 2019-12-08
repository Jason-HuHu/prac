package com.huxl.java8.chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

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
        process(System.out::println);

        //正常读取一行:
      /*  String oneLine = processFile();
        System.out.println(oneLine);
        oneLine = processFile((br) -> br.readLine());
        System.out.println(oneLine);
        String twoLine = processFile((br)->br.readLine() + br.readLine());
        System.out.println(twoLine);*/

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



        //任何函数式接口都不允许抛出受检查异常(checked Exception) 如果需要lambda表达式来抛出异常1：自定义一个函数式接口，并声明受检查异常，或者把lambda包在try/cache中
        System.out.println("类型检查、类型推断及限制");
        System.out.println("Lambda表达式的类型是从Lambda表达式的上下文推断出来的：接受Lambda表达式的方法的参数，接受它值的局部变量等");
        /*
            1.找到方法声明
            2.目标类型
            3.找到函数式接口的抽象方法
            4.抽象方法的函数描述符
            5.匹配
         */
        //同一个Lambda表达式可以用于多个不同的函数接口中
        Runnable r = ()->{
            System.out.println("");
        };
        r.run();
        //类型推断：Java编译器会从上下文（目标类型）推断出用什么函数式接口来配合Lambda表达式
        //Lambda表达式使用局部变量
        //局部变量必须是final的或者最终是final的，也就是不能再次赋值
        final int portNumber = 1;
        Runnable r3 = () -> System.out.println(portNumber);
        r3.run();
        //为什么局部变量有一些限制：1.实例变量存储在堆上，而局部变量存储在栈上2.不鼓励使用改变外部变量的典型命令式编程方式
        //闭包：闭包就是一个函数的实例，而且它可以无限制地访问那个函数的非本地变量，例如闭包可以作为参数传递给另一个函数，可以访问
        //和修改其作用域之外的变量，现在Java8的Lambda表达式和匿名类可以做类似的事情：他们可以作为参数传递给方法，可以访问其作用域之外的变量
        //有一个限制：不能修改Lambda表达式的方法的局部变量的内容，这些变量必须是隐式最终的(final)
        //Lambda表达式对值封闭，但是对变量不封闭

        //方法引用System.out::println 目标引用在::前，方法名称在后，不需要括号，没有真正的调用
        System.out.println("如何构建方法引用？");
        //1.指向静态方法的方法引用 Integer::parseInt
        //2.指向任意类型实例方法的方法引用String::length (String s) -> s.toUpperCase() => String::toUpperCase
        //3.指向现有对象的实例方法的方法引用 () ->expensiveTransaction.getValue() expensiveTransaction::getValue
        BiPredicate<List<String>,String> contains = List::contains;

        //构造方法引用

        //实战 给一个Apple列表用不同规则排序 ：行为参数化、匿名类、Lambda表达式和方法引用
        List<Apple> apples =  map(Arrays.asList(5,6,1,2,3),Apple::new);
        sortApple(apples);
        //复合Lambda表达式
        Comparator<Apple> c = Comparator.comparing(Apple::getWeight);
        //逆序
        apples.sort(c.reversed());
        //比较器链,先比较重量，再比较颜色等等
        apples.sort(c.reversed().thenComparing(Apple::getColor));
        //谓词复合negate and  or
        //函数复合
        Function<Integer,Integer> f = x -> x + 1;
        Function<Integer,Integer> g = x -> x * 2;

        Function<Integer,Integer> h = f.andThen(g);
        Function<Integer,Integer> h1 = f.compose(g);
        //结果为 4 g(f(x))
        int re = h.apply(1);

        //Lambda表达式等效的方法引用
        Function<String,Integer> stringIntegerFunction = (String s) -> Integer.parseInt(s);
        Function<String,Integer> stringIntegerFunction1 = Integer::parseInt;

        BiPredicate<List<String>,String> contains1= (list,element) -> list.contains(element);
        BiPredicate<List<String>,String> contains2= List::contains;
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

    private static void constructorMethodReffer(){
        Supplier<Apple> a = Apple::new;
        Apple apple = a.get();

        Function<Integer,Apple> a1 = Apple::new;
        Apple apple1 = a1.apply(100);

        //创建不同重量苹果集合
        List<Apple> apples = map(Arrays.asList(1,2,3),Apple::new);

        BiFunction<String,Integer,Apple> a3 = Apple::new;
        Apple apple2 = a3.apply("red",110);

    }

    private static void sortApple(List<Apple> oriList) {
        List<Apple> result = new ArrayList<>();
        //1.实现接口，传递对象
        class AppleComparator implements Comparator<Apple>{

            @Override
            public int compare(Apple o1, Apple o2) {
                return new Integer(o1.getWeight()).compareTo(new Integer(o2.getWeight()));
            }
        }

        oriList.sort(new AppleComparator());
        //2.使用匿名内部类
        oriList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return new Integer(o1.getWeight()).compareTo(new Integer(o2.getWeight()));
            }
        });
        //3.Lambda表达式
        oriList.sort((Apple a1,Apple a2) -> new Integer(a1.getWeight()).compareTo(new Integer(a2.getWeight())));
        //4.省略参数类型
        oriList.sort((a1,a2) -> new Integer(a1.getWeight()).compareTo(new Integer(a2.getWeight())));
        //5.使用静态辅助方法
        oriList.sort(Comparator.comparing(a -> a.getWeight()));
        //6.凡使用方法引用
        oriList.sort(Comparator.comparing(Apple::getWeight));
    }
}

class Apple{
    private int weight;
    private String color;

    public Apple(){}

    public Apple(int weight) {
        this.weight = weight;
    }

    public Apple(String color,int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
