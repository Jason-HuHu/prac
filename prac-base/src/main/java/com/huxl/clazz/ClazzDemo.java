package com.huxl.clazz;

/**
 * 获取字节码（Class）对象的三种方式
 *
 * @author xiaoh
 * @since 2019/2/20 10:28
 */
public class ClazzDemo {
    public static void main(String[] args) throws ClassNotFoundException {

        Class clazz1 = String.class;

        Class clazz2 = Class.forName("java.lang.String");

        String str = new String("");
        Class clazz3 = str.getClass();

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz2 == clazz3);

        /*
            true
            true
            true
            同一个类在JVM中只有一份字节码对象
         */

        /*
        JVM中内置九大Class实例
         */

        System.out.println(int.class);
        System.out.println(short.class);
        System.out.println(char.class);
        System.out.println(long.class);
        System.out.println(double.class);
        System.out.println(float.class);
        System.out.println(boolean.class);
        System.out.println(byte.class);
        System.out.println(void.class);

        //8大基本数据类型的包装类型中都有一个常量 TYPE 用于返回该包装类对应基本类的字节码对象
        System.out.println("8大基本数据类型的包装类型中都有一个常量 TYPE 用于返回该包装类对应基本类的字节码对象");
        System.out.println(Integer.TYPE == int.class);
        System.out.println(Short.TYPE == short.class);
        System.out.println(Character.TYPE == char.class);
        System.out.println(Long.TYPE == long.class);
        System.out.println(Double.TYPE == double.class);
        System.out.println(Float.TYPE == float.class);
        System.out.println(Boolean.TYPE == boolean.class);
        System.out.println(Byte.TYPE == byte.class);

        //所有具有相同维度和元素类型的数组共享同一份字节码对象，和元素无关
        System.out.println("所有具有相同维度和元素类型的数组共享同一份字节码对象，和元素无关");
        String[] arr1 = new String[]{"1","2"};
        String[] arr2 = new String[]{"a","b"};
        System.out.println(arr1.getClass() == arr2.getClass());
    }
}
