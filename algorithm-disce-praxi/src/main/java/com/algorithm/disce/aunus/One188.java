package com.algorithm.disce.aunus;

public class One188 {

    public int maxProfit(int k, int[] prices) {
        //子问题 求到第i天最多进行k次股票交易后后能得到最大利润
        //状态定义 dp[i][k][j]
        //状态定义 i:到第i天 k:第k次交易 j: 0.持有股票 1.不持有股票
        //dp方程
        //dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k-1][1]-prices[i])
        //dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k][0]+prices[i])
        //if k >= prices.length / 2
        //可交易次数k超过这个临界值，其所能得到最终最大利润和可无限次交易的最终利润是一致的
        //在可无限次交易情况，可以定义 k-1 = k,那么得到dp方程 k 维度是没有作用, 可以简化为
        //dp[i][0] = max(dp[i-1][0],dp[i-1][1]-prices[i])
        //dp[i][1] = max(dp[i-1][1],dp[i-1][0]+prices[i])

        int n = prices.length;
        if (n == 0) return 0;

        if (k >= n / 2) {
            return unlimitedPrices(prices);
        }

//        int[][] dp = new int[k+1][2];
//        for (int i = 1; i <= k; i++) {
//            dp[i][0] = -prices[0];
//        }
//
//        int ans = 0;
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j <= k; j++) {
        //这里要用 dp[j - 1][1] - 今天股票额,即上一次卖出后买入
//                dp[j][0] = Math.max(dp[j][0], dp[j][1] - prices[i]);
//                dp[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
//                if (i == n - 1) {
//                    ans = Math.max(ans, dp[j][1]);
//                }
//            }
//        }
//        return ans;

        int[][] dp = new int[k + 1][2];
        for (int i = 1; i <= k; i++) {
            dp[i][0] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = k; j > 0; j--) {
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
            }
        }
        return dp[k][1];
    }

    private int unlimitedPrices(int[] prices) {
        int pre = -prices[0];
        int cur = 0;
        for (int i = 1; i < prices.length; i++) {
            pre = Math.max(pre, cur - prices[i]);
            cur = Math.max(cur, pre + prices[i]);
        }
        return cur;
    }

}
