package com.huxl.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 原理：将元素依次插入已经有序的序列中
 * 参考：https://www.runoob.com/w3cnote/insertion-sort.html
 * Simple insertion sort
 */
public class InsertionSort implements IArraySort {

    public static void main(String[] args) {
        Integer[] arr = of(324,1,2,3,4,522,23423);
        insertionSort(arr);
        System.out.println(arr);
    }


    private static Integer[] of(Integer... values){
        return values;
    }

    private static <T extends Comparable> void insertionSort(T[] a) {
        int j;
        for (int p = 1;p < a.length; p++) {
            T temp = a[p];
            for (j = p; j > 0 && temp.compareTo(a[j-1]) < 0; j--) {
                a[j] = a[j-1];
            }
            a[j] = temp;
        }
    }

    @Override
    public int[] sort(int[] array, boolean asc) {
        int[] arr = Arrays.copyOf(array,array.length);
        //从下标为1的元素开始，因为下标为0的只有一个元素，默认有序的
        for (int i = 1;i < arr.length; i++) {
            //记录要插入的值
            int temp = arr[i];
            //从已经排序的数组右边开始找到第一个比当前值小的位置
            int j = i;
            while (j > 0 && temp < arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            //存在比当前值小数
            if (j != i) {
                arr[j] = temp;
            }
        }
        return arr;
    }
}
