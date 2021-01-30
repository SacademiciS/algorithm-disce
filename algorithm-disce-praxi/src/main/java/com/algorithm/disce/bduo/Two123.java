package com.algorithm.disce.bduo;

public class Two123 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        //子问题 求第i天最多进行两次股票交易能得到最大利润
        //状态数组 dp[i][k][j]
        //状态定义 k : 第几次交易 j: 0.持有股票 1.空仓
        //dp方程
        //dp[i][1][0] = max(dp[i-1][1][0],dp[i-1][0][0] - prices[i])
        //dp[i][1][1] = max(dp[i-1][1][1],dp[i-1][1][0] + prices[i])
        //dp[i][2][0] = max(dp[i-1][2][0],dp[i-1][1][1] - prices[i])
        //dp[i][2][1] = max(dp[i-1][2][1],dp[i-1][2][0] + prices[i])

        int[][] dp = new int[3][2];

        dp[1][0] = -prices[0];
        dp[2][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[1][0] = Math.max(dp[1][0], dp[0][0] - prices[i]);
            dp[1][1] = Math.max(dp[1][1], dp[1][0] + prices[i]);
            dp[2][0] = Math.max(dp[2][0], dp[1][1] - prices[i]);
            dp[2][1] = Math.max(dp[2][1], dp[2][0] + prices[i]);
        }
        return dp[2][1];
    }

}
