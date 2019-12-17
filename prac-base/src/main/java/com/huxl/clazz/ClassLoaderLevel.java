package com.huxl.clazz;

/**
 * 类中成员的加载顺序
 * 1.静态变量和静态代码块是在类加载的时候就执行的
 * 2.同类型的（静态变量静态代码块、变量和代码块）先声明先执行
 *
 * 顺序
 * 静态变量静态代码块
 * 构造代码块
 * 构造函数
 * 父类静态代码块
 * 子类静态代码块
 * 父类构造代码块
 * 父类构造函数
 * 子类构造代码块
 * 子类构造函数
 * @author huxl
 * @since 2019/12/17-9:12
 */
public class ClassLoaderLevel {
    {
        System.out.println("this block");
    }
    static {
        System.out.println("this static block");
    }

    public static void main(String[] args) {
        new SubClass();
        new ClassLoaderLevel();
    }
}

class Parent{
    public static final int a = 1;
    {
        System.out.println("parent's block");
    }

    static {
        System.out.println("parent static block2");
    }
    static {
        System.out.println("parent static block");
    }

    Parent(){

        System.out.println("parent's construct");
    }

}

class SubClass extends Parent{
    {
        System.out.println("child's block");
    }

    static {
        System.out.println("child's static block");
    }

    public SubClass(){

        System.out.println("child's construct");
    }
    static {
        System.out.println("child's static block2");
    }
}
