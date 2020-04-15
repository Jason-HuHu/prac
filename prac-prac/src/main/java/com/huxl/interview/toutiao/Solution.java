package com.huxl.interview.toutiao;

public class Solution {

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canBack(gas,cost));
    }

    private static int canBack(int[] gas, int[] cost) {
        //剩下的油
        int x = 0;
        //走了多少步
        int step = 0;
        //最多从尾部再回到尾部
        for (int i = 0;i < gas.length * 2; i++) {

            int index = i;
            if (i >= gas.length) {
                index = i-gas.length;
            }
            if (step == gas.length) {
                return index;
            }
            x = x + gas[index];
            if ((x= x - cost[index]) >= 0) {
                step ++;
                continue;
            }
            step = 0;
            x =0;
        }
       return -1;
    }
}
