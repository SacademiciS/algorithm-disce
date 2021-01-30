package com.algorithm.disce.ctribus;

public class Three188 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        if (k >= n / 2) {
            return greedy(prices);
        }
        //子问题 求到第i天最多可以经过k次交易得到最大利润
        //状态数组 dp[i][k][j]
        //状态定义 k：最多可以经过k次交易  j: 0.空仓 1.持仓
        //dp方程
        //dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
        //dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
        int[][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[i][1] = Integer.MIN_VALUE;
        }

        for (int p : prices) {
            for (int i = 1; i <= k; i++) {
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] - p);
                dp[i][0] = Math.max(dp[i][0], dp[i][1] + p);
            }
        }
        return dp[k][0];
    }

    private int greedy(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }

}
