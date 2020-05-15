package com.huxl.leetcode;

/**
 * 和为k的连续子数组数量
 *
 */
public class SubArraySumDemo {
    public static void main(String[] args) {
        int[] nums = {28,54,7,-70,22,65,-6};
        int num = subarraySum(nums,100);
        System.out.println(num);
    }
    public static int subarraySum(int[] nums, int k) {
        //暴力解法
        int count = 0;
        for (int start = 0;start < nums.length ;start++) {
            int sum = 0;
            for (int end = start;end < nums.length;end++) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
