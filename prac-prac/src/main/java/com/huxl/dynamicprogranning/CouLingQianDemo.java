package com.huxl.dynamicprogranning;

/**
 * 凑零钱
 * 给定不同面额的硬币coins 和一个总金额amount ，编写一个函数来计算可以凑成总金额的最小硬币数
 * 如果没有任何一种硬币组合可以组成总金额，返回 -1，例如
 * 输入 coins = [1,2,5] amount = 11 输出 3 ；解释：5 + 5 + 1 = 11
 * 输入 coins = [2] amount = 3 输出：-1
 */
public class CouLingQianDemo {

    private static int f(int amount,int[] coins) {
        //递归四部曲
        //1.定义一个函数，明确函数的功能
        //2.寻找问题与子问题之间的关系，即递推公式
        /*
           当选了了第一枚银币后的递推公式
           f(amount,coins) = f(amount-coins[0],coins) + 1 这里+1代表选择了一枚硬币
           //如果选择了第二枚第三枚呢？
           f(amount,coins) = f(amount-coins[1],coins) + 1 这里+1代表选择了第二枚硬币
           f(amount,coins) = f(amount-coins[2],coins) + 1 这里+1代表选择了第三枚硬币
           我们的目标是找到所有以上f(amount,coins)解的最小值，于是可以得出总的递推公式：
           f(amount,coins) = min{f(amount-coins[i]) + 1} 其中i的取值为 0 到 coins.length coins[i]表示选择了该枚硬币，+1表示选取得硬币数+1

         */
        //说明零钱刚好凑完
        if (amount == 0) {
            return 0;
        }
        //说明没有满足条件的
        if (amount < 0) {
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subMin = f(amount - coins[i],coins);
            if (subMin == -1 ) continue;
            result = Math.min(subMin + 1,result);
        }
        //说明没有符合条件的解
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }
}
