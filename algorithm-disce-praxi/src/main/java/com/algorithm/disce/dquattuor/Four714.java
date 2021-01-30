package com.algorithm.disce.dquattuor;

public class Four714 {

    public int maxProfit(int[] prices, int fee) {
        //子问题 求到第i天进行股票交易得到最高利润
        //状态数组 dp[i][j]
        //状态定义 j: 0.持有股票 1.空仓
        //dp方程
        //dp[i][0] = max(dp[i-1][0],dp[i-1][1]-prices[i]-fee)
        //dp[i][1] = max(dp[i-1][1],dp[i-1][0]+prices[i])
        int n = prices.length;
        int pre = -prices[0] - fee;
        int cur = 0;

        for (int i = 1; i < n; i++) {
            pre = Math.max(pre, cur - prices[i] - fee);
            cur = Math.max(cur, pre + prices[i]);
        }
        return cur;
    }

}
