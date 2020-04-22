package com.huxl.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 原理：比较两个相邻的元素，将值大的元素交换至右端。
 * 思路：依次比较相邻的两个数，将小数放在前面，大数放在后面
 * 参考：https://www.runoob.com/w3cnote/bubble-sort.html
 * @author huxingl
 * @since 2018/8/30 14:48
 */


public class BubbleSort implements IArraySort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 9, 1};
        System.out.println("排序前数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        for (int i = 0; i < arr.length - 1; i++) {//外层循环控制排序趟数
            for (int j = 0; j < arr.length - 1 - i; j++) {//内层循环控制每一趟排序多少次
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println();
        System.out.println("排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    @Override
    public int[] sort(int[] array) {

        return sort(array,true);
    }

    @Override
    public int[] sort(int[] array, boolean asc) {
        int[] arr = Arrays.copyOf(array,array.length);

        //外层循环控制排序次数
        for (int step = 0; step < arr.length; step++) {
            //如果没有改变过元素相对顺序，则已经排好序了，不用再排序
            boolean sorted = true;
            //内层循环控制每一趟排序的比较次数
            for (int count = 0; count < arr.length -1 - step; count++) {
                if (asc) {
                    if ( arr[count] > arr[count + 1]) {
                        int temp = arr[count];
                        arr[count] = arr[count + 1];
                        arr[count  + 1] = temp;
                        sorted = false;
                    }
                } else {
                    if ( arr[count] < arr[count + 1]) {
                        int temp = arr[count];
                        arr[count] = arr[count + 1];
                        arr[count  + 1] = temp;
                        sorted = false;
                    }
                }
            }
            if (sorted) {
                break;
            }
        }
        return arr;
    }
}
