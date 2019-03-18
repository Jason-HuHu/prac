package com.huxl.keyword;

/**
 * 关键词测试
 *
 * @author xiaoh
 * @since 2019/3/18 10:46
 */
public class KeyWordDemo {
    public static void main(String[] args) {
        FinalDemo finalDemo = new FinalDemo();

        FinalDemo.Person person = new FinalDemo().new Person();
        person.setName("p1");
        person.setAge(1);

        person = new FinalDemo().new Person();
        person.setName("p2");
        person.setAge(2);

        FinalDemo.Person person1 = person;

        //final修饰的变量是不能再被赋值的
//        FinalDemo.FINAL_STR = "1";
//        FinalDemo.FINAL_INT = 2;

        final int[] arr = {1,3,4};
        int[] another = {2,3,4};
        another = arr;
        //报错
//        arr = another;
    }
}
