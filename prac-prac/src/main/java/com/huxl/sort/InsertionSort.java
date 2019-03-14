package com.huxl.sort;

/**
 * 插入排序
 * Simple insertion sort
 */
public class InsertionSort {

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
}
