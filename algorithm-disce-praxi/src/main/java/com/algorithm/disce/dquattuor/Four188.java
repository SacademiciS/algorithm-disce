package com.algorithm.disce.dquattuor;

public class Four188 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        //子问题 求到第i天最多进行k次股票交易得到最高利润
        //状态数组 dp[i][j][k]
        //状态定义 j: 0.持有股票 1.空仓 k:最多进行k次交易
        //dp方程
        //dp[i][0][k] = max(dp[i-1][0][k],dp[i-1][1][k-1]-prices[i])
        //dp[i][1][k] = max(dp[i-1][1][k],dp[i-1][0][k]+prices[i])
        if (k >= n / 2) {
            return unLimitPrice(prices);
        }

        int[][] dp = new int[2][k + 1];
        for (int i = 1; i <= k; i++) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = k; j > 0; j--) {
                dp[0][j] = Math.max(dp[0][j], dp[1][j - 1] - prices[i]);
                dp[1][j] = Math.max(dp[1][j], dp[0][j] + prices[i]);
            }
        }

        return dp[1][k];
    }

    private int unLimitPrice(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

}
