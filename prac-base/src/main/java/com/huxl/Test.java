package com.huxl;

/**
 * TODO..
 *
 * @author huxingl
 * @since 2018/11/15 19:03
 */


public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int i = arr.length;
        while (i != -1) {
            System.out.println(arr[--i]);
        }
    }
}
