package com.huxl.operator;

import java.beans.Introspector;

/**
 * @author huxl
 * @createDate 2018/3/14 9:15
 */
public class BitOpertaor {
    public static void main(String[] args) {

        //左移运算符
//        testZYOper();
        lowerFirstWord();
    }
    private static void testZYOper(){
        int i = 8;
        System.out.println(i << 3);
    }

    //将单词首字母变为小写

    /**
     * @see Introspector
     * decapitalize(String name) 方法可以将首字母变为小写
     *
     * Food -> food
     * URL -> URL
     * X   -> x
     *
     */
    private static void lowerFirstWord(){
        String str = "LowerFirstWord";
        String str1 = "AAhelloWorld";
        System.out.println(Introspector.decapitalize(str1));

        char[] strs = str.toCharArray();
        strs[0] += 32;
        char[] str1s = str1.toCharArray();
        str1s[0] += 32;

        System.out.println(str + "首字母变为小写：" + String.valueOf(strs));
        System.out.println(str1 + "首字母变为小写：" + String.valueOf(str1s));

    }

    private static String decapitalize(String name) {
        //为空或者null则返回
        if (name == null || name.length() == 0) {
            return name;
        }

        //前面两个首字母都是大写的则不变
        if (name.length() > 1 && Character.isUpperCase(name.charAt(1)) && Character.isUpperCase(name.charAt(0))) {
            return name;
        }
        //将首字母变为小写
        char[] chars = name.toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        return new String(chars);
    }
}
