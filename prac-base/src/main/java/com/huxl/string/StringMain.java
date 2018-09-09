package com.huxl.string;

/**
 * 字符串相关处理
 *
 * @author huxingl
 * @since 2018/8/20 10:01
 */


public class StringMain {
    public static void main(String[] args) {
        testNullAdd();
    }
    
    private static void testNullAdd(){
        String str = null;
        String hello = "hello test";
        System.out.println(str += hello);
    }
}
