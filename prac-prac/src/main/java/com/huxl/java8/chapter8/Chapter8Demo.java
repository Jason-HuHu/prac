package com.huxl.java8.chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 使用Lambda表达式重构代码
 * @author huxl
 * @since 2019/11/22-20:34
 */
public class Chapter8Demo {
    public static void main(String[] args) {
        /*
            策略模式
            模板方法
            观察者模式
            责任链模式
            工厂模式
         */
    }

    public static void lambda(){
        //1.使用Lambda表达式替换匿名类
        Runnable r1  = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };
        //替换为
        Runnable r2 = ()-> System.out.println("Hello");
        //一种可能导致晦涩的改变方式
        doSomething(new Task() {
            @Override
            public void execute() {
                System.out.println("Task");
            }
        });
        //需要显示类型转换解决模棱两可的情况
        doSomething((Task) ()-> System.out.println("Task"));

        doSomething((Runnable) ()-> System.out.println("Task"));

        //2.从Lambda表达式到方法引用的转换
        //尽量使用辅助静态方法，比如排序，归约等操作，比Lambda表达式更加直观

        //3.从命令式的数据处理切换到Stream
        List<String> teachers = new ArrayList<>();
        List<Person> users = new ArrayList<>();
        for (Person user : users) {
            if (user.getAge() > 20 ) {
                teachers.add(user.getName());
            }
        }
        //===>并行处理成为可能
        List<String> t1 = users.parallelStream()
                .filter(user -> user.getAge() > 20)
                .map(Person::getName)
                .collect(Collectors.toList());

    }

    interface Task{
        public void execute();
    }

    public static void doSomething(Runnable r) {
        r.run();
    }

    public static void doSomething(Task t) {
        t.execute();
    }

    class Person{
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
