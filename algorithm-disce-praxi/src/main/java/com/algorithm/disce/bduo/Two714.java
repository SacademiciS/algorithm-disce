package com.algorithm.disce.bduo;

public class Two714 {

    public int maxProfit(int[] prices, int fee) {
        //子问题 求到第i天进行股票交易后能得到最大利润
        //状态方程 dp[i][j]
        //状态定义 i:到第i天 j: 0.持有股票 1.不持有股票
        //dp方程
        //dp[i][0] = max(dp[i-1][0],dp[i-1][1]-prices[i]-fee);
        //dp[i][1] = max(dp[i-1][1],dp[i-1][0]+prices[i]);

        int n = prices.length;
        int[] dp = new int[2];

        dp[0] = -prices[0] - fee;

        for (int i = 1; i < n; i++) {
            dp[0] = Math.max(dp[0], dp[1] - prices[i] - fee);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
        }
        return dp[1];

        //dp[1]可以利用当天的dp[0]的原因如下：
        //这其中有两种情况：
        //1.当dp[0]=dp[0]时,今天的dp[0]相当于昨天的dp[0]，可直接利用。
        //2.当dp[0]=dp[1] + prices[i]时，将dp[0]=dp[1] + prices[i]代入式子dp[1] = Math.max(dp[1], dp[0] - prices[i] - fee)。
        //可得dp[1] = Math.max(dp[1], dp[1] + prices[i] - prices[i] - fee)
        //即dp[1] = Math.max(dp[1], dp[1] - fee)
        //而昨日的d[0]比今日的d[0]更小，若将今日d[0]代入， dp[1] - fee将会更小。
        //由此可得，在dp[0]=dp[1] + prices[i]时，今天的d[1]必将等于昨日的d[1]，与d[0]无关。
        //若将这两条公式顺序对换，亦不会对结果造成影响。
        //dp[0] = Math.max(dp[0], dp[1] + prices[i]);
        //dp[1] = Math.max(dp[1], dp[0] - prices[i] - fee);
    }

}
