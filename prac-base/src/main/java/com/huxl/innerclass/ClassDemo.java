package com.huxl.innerclass;

/**
 * 内部类研究Demo
 *
 * @author huxingl
 * @since 2018/7/31 9:03
 */


public class ClassDemo {
    
    public static void main(String[] args) {
        System.out.println("非静态内部类不能有静态成员，静态内部类可以有静态成员");
        System.out.println("静态内部类只能访问外部类的静态成员，而非静态内部类可以访问外部类的所有成员");
        
        OuterClass outerClass = new OuterClass();
        outerClass.setOuterName("OUTER_NAME");
        outerClass.getUsage();
        
        outerClass.getInnerclass();
        outerClass.getInnerStaticClass();
    }
}
