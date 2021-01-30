package com.algorithm.disce.aunus;


public class One309 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        //子问题 求第i天进行股票交易能得到最大利润
        //状态数组 dp[i][j]
        //状态定义 j: 0.持有股票 1.冷冻期 2.保持空仓
        //dp方程
        //dp[i][0] = max(dp[i-1][0], dp[i-1][2]-prices[i]);
        //dp[i][1] = dp[i-1][0] + prices[i];
        //dp[i][2] = max(dp[i-1][2],dp[i-1]][1]);
        int hold = -prices[0];
        int freeze = 0;
        int empty = 0;

        for (int i = 1; i < n; i++) {
            int t1 = Math.max(hold, empty - prices[i]);
            int t2 = hold + prices[i];

            empty = Math.max(freeze, empty);
            hold = t1;
            freeze = t2;
        }

        return Math.max(freeze, empty);
    }

}
