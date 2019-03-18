package com.huxl.keyword;

/**
 * final可以用来修饰类、变量和方法
 * final修饰类，表明该类不想被继承
 * final修饰方法，表示该方法不想被子类重写（如果父类的final方法是private的，则子类可以写一个同名方法）
 * final修饰变量=定义一个常量
 *  1.基本数据类型 值不再改变
 *  2.如果是引用类型，则地址不变，但是对象是可以被修改的
 *
 *
 * @author xiaoh
 * @since 2019/3/18 10:45
 */
public class FinalDemo {

    public final static String FINAL_STR = "final";
    public final static int FINAL_INT = 1;

    class Animal{
        final int age(){
            return Integer.MAX_VALUE;
        }
    }

    final class Person extends Animal{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
        //final修饰的方法不能重写
//        public int age(){
//            return 100;
//        }
    }
    //final修饰的类不能被继承
//    class SubPerson extends Person{}

    public String testStr(final String name){

        final StringBuilder sb = new StringBuilder("test");
        sb.append("change");
        sb.append(name);

        return sb.toString();
    }


}
