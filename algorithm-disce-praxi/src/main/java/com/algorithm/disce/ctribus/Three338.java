package com.algorithm.disce.ctribus;

public class Three338 {

    public int[] countBits(int num) {
        //动态规划
        //状态定义：第i个数的二级制中1的数目
        //状态数组：dp[i]
        //dp方程：dp[i] = dp[i&(i-1)] + 1
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[(i & (i - 1))] + 1;
        }
        return dp;
    }

}
