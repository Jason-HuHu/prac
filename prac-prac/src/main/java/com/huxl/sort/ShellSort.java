package com.huxl.sort;

import java.util.Arrays;

/**
 * 原理：希尔排序也称递减增量排序，是插入排序一种更高效的改进版本，但是希尔排序是非稳定的排序算法
 * 基本思想：先将待排序的的记录序列分割成若干子序列分别进行直接插入排序，待整个序列中的记录基本有序的时候再对全体记录依次进行直接插入排序
 * 参考：https://www.runoob.com/w3cnote/shell-sort.html
 */
public class ShellSort implements IArraySort {
    public static void main(String[] args) {
        System.out.println(2/3);
    }
    @Override
    public int[] sort(int[] array, boolean asc) {
        int[] arr = Arrays.copyOf(array,array.length);
        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - gap;
                while (j >=0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }
            //除以3向下取整
            gap = gap / 3;
        }
        return arr;
    }
}
