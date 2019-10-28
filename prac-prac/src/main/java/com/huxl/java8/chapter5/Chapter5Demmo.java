package com.huxl.java8.chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chapter5Demmo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        //筛选和切片
        //filter 使用的类型或者函数式接口：Predicate<T> 函数描述符 T-> boolean 传入一个类型T元素，返回boolean值
        //映射
        //map  Function<T,R>  T -> R
        //flatMap Function<T,Stream<R>> T->Stream<R>
        //查找和匹配
        //规约
        //reduce ： BinaryOperator<T> (T,T)-> T 合并为一个处理
        test();
    }

    private static void test(){
        /*
            (1) 找出2011年发生的所有交易，并按交易额排序，从低到高
            (2) 交易员都在哪些不同城市工作过
            (3) 查找所有来自剑桥的交易员，并按姓名排序
            (4) 返回所有交易员的姓名字符串，并按字母顺序排序
            (5) 有没有交易员是在米兰工作的
            (6) 打印所有生活在剑桥的交易员的所有交易额
            (7) 所有交易中，最高的交易额是多少
            (8) 找到交易额最小的交易
         */
        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,950)
        );
        //(1)答案
        List<Transaction> tr2011 = transactions.stream()
                .filter(tr -> tr.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        //(2)答案
        List<String> cities = transactions.stream()
                .map((tr) -> tr.getTrader().getCity())
                //可以用toSet替换 .collect(Collectors.toSet())
                .distinct()
                .collect(Collectors.toList());
        //(3)答案
        List<Trader> traders = transactions.stream()
                //提取所有交易员
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        //(4)答案
        String nameStr = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                //这种拼接方式效率不高
//                .reduce("",(n1,n2) -> n1 + n2);
                .collect(Collectors.joining());
        System.out.println("所有交易员的名称：" + nameStr);
        //(5)答案
        boolean milanBased = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println("是否有员工在米兰工作：" + milanBased);
        //(6)答案
        transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
        //(7)答案
        Optional<Integer>  higestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println("最高交易额"+ higestValue);

        //(8)答案
        Optional<Transaction> smallestTransaction = transactions
                .stream()
//                .reduce((t1,t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println("交易额最小的交易：" + smallestTransaction);


    }

    private static void testNumberStream(){
        /*
         * 原始类型流特化
         * IntStream LongStream DoubleStream
         *
         */
        IntStream evenNumbers = IntStream.rangeClosed(1,100)
                .filter( n-> n % 2 == 0);
        System.out.println(evenNumbers.count());
        //range不包含结束值，rangeClose包含结束值

        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1,100)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a,100)
                .filter(b->Math.sqrt(a*a + b*b) % 1 == 0).mapToObj( b-> new int[]{a,b,(int)Math.sqrt(a*a + b*b)}));
        //优化，先构建所有三元组再过滤
    }
    private static void testBuildStream(){
        //由值创建流
        Stream<String> stream = Stream.of("Java8","Lambdas","In","Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
        //由数组创建
        //由文件生成
//        Files.lines("").forEach();
        //由函数生成
//        Stream.generate(suppliers)
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
//        Stream.iterate(seed,Stream.iterate())

    }

}

class Trader{
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}

class Transaction{
    private final Trader Trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        Trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return Trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "Trader='" + Trader + '\'' +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}