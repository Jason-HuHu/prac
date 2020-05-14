package com.huxl.interview.mi;

/**
 * 给定一个递增数组，找绝对值最小的那个数
 * 要求不能O（n）遍历
 * 思路：绝对值最小，那么就是最靠近0的那个数，可以二分查找
 */
public class MinAbsoluteNumDemo {

    public static void main(String[] args) {
        int[] arr = {-10,-8,-1,1,2,3,4,5,10};
        //二分查找0
        int min = binarySearch(arr);
        System.out.println(min);

    }

    private static int binarySearch(int[] arr) {
        int start = 0;
        int end = arr.length -1;
        int min = Integer.MAX_VALUE;
        boolean flag = false;
        while (start <= end) {
            //计算中间索引值
            int middle = (end + start) >>> 1;//防止溢出
            if (0 == arr[middle]) {
                return 0;
            }else if (0 < arr[middle]) {
                end = middle - 1;
                if (min > arr[middle]) {
                    min = arr[middle];
                    flag = false;
                }
            }else {
                start = middle + 1;
                if (min > -arr[middle]) {
                    min = -arr[middle];
                    flag = true;
                }
            }
        }
        return flag ? -min : min;

    }
}
