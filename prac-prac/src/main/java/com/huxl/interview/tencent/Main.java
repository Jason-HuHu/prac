package com.huxl.interview.tencent;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 腾讯笔试题
 * 给一个序列，求子序列和小于指定值k 的最大长度
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int len = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[len];
            for (int i=0;i< len;i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(max(arr,k));
        }


    }
    private static int max(int[] arr,int k){
        if (arr == null || arr.length == 0) {
                return 0;
        }

        int[] sums = new int[arr.length];
        //存储某个位置下最长子序列的和
        HashMap<Integer, Integer> ends = new HashMap<>();
        // 以某个位置开头，得到的最小和。
        sums[arr.length - 1] = arr[arr.length - 1];
        // 当前位置下，最长子序列的最小和
        ends.put(arr.length - 1, arr.length - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (sums[i + 1] < 0) {
                sums[i] = arr[i] + sums[i + 1];
                ends.put(i, ends.get(i + 1));
            } else {
                sums[i] = arr[i];
                ends.put(i, i);
            }
        }
        int end = 0;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++)
        {
            while (end < arr.length && sum + sums[end] <= k)
            {
                sum += sums[end];
                end = ends.get(end) + 1;
            }
            //这里是为了防止刚开始的时候end==i,就不满足，这样sum没有被加过，所以一直为0，所以不需要减去任何值
            sum -= end > i ? arr[i] : 0;
            res = Math.max(res, end - i);
            //这里是为了防止刚开始的时候end==i,需要把end值往后移动一个位置，向右扩展。i是自增的
            end = Math.max(end, i + 1);
        }
        return res;

    }
}
