package com.huxl.sort;

/**
 * @author huxl
 * @createDate 2017/11/13 16:17
 */
public class QuickSort {
    private static int[] arr = {12,8,4,5,7,9,4};
    private static int n ;
    public static void main(String[] args) {
        new QuickSort().quicksort(0,arr.length-1);
        System.out.print("quicksort result : ");
        for (int i = 0 ; i < arr.length;i++) {
            System.out.print( arr[i] + ",");
        }
    }

    /**
     * 快速排序
     * @param left 排序左下标
     * @param right 排序右下标
     * @see "http://ahalei.blog.51cto.com/4767671/1365285"
     * 快速排序的思路：
     * 在给定的待排数组中选定一个基数值，比基数值大的数据移动到右边，比基数值小的移到左边，递归执行，得到升序后的数组
     *
     * 选定两个哨兵i和j,i从左边扫描数组，j从右边扫描数组，当i的值比基数值大，j的值比基数值小的时候，交换
     * i和j的值，直到i和j相遇，i和j相遇后，将基准数归位。
     *
     */
    public void quicksort(int left, int right){
       int i,j,t,temp;

       if (left > right) {
           return;
       }

       //temp中存的是基准数
       temp = arr[left];
       i = left;
       j = right;
       while (i != j) {
            while (arr[j] >= temp && i < j) {
                j--;
            }
            while (arr[i] <= temp && i < j) {
                i++;
            }
            //交换两个数在数组中的位置
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
       }

       //基准数归位
        arr[left] = arr[i];
        arr[i] = temp;
        //递归执行
        quicksort(left,i-1);
        quicksort(i + 1,right);
    }
}
