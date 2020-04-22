package com.huxl.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 原理：每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，直到全部记录排序完毕。
 * 参考：https://www.runoob.com/w3cnote/selection-sort.html
 *
 * @author huxingl
 * @since 2018/8/30 14:48
 */


public class SelectionSort implements IArraySort{

    @Override
    public int[] sort(int[] array, boolean asc) {
        int[] arr = Arrays.copyOf(array,array.length);
        //总共经过N-1轮比较
        for (int step = 0; step < arr.length - 1; step++) {
            //if asc 这里应该是max
            int min = step;
            for (int j = step + 1; j < arr.length; j++) {
                if (asc) {
                    if (arr[j] < arr[min]) {
                        //记录目前最小值的下标
                        min = j;
                    }
                }else {
                    if (arr[j] > arr[min]) {
                        //记录目前最小值的下标
                        min = j;
                    }
                }

            }
            //说明最小值发生过变化
            if (step != min) {
                int temp = arr[step];
                arr[step] = arr[min];
                arr[min] = temp;
            }
//            int min = arr[step];
//            for (int j = step + 1; j < arr.length; j++) {
//                if (arr[j] < min) {
//                    //这样会发生多次数据移动，直接记录最小值下标效率比较高
//                    int temp = arr[j];
//                    arr[j] = min;
//                    min = temp;
//                }
//            }
        }
        return arr;
    }
}
