package com.algorithm.disce.bduo;

public class Two188 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        if (k >= n / 2) {
            return unLimitPrices(prices);
        }

        int[][] dp = new int[k + 1][2];
        for (int i = 1; i <= k; i++) {
            dp[i][0] = -prices[0];
            //这里有区别
            //dp[i][0] = Integer.MIN_VALUE;
            //这里区别在于使用Integer.MIN_VALUE是定义第1天前即第0天的状态数组初始化
            //而使用 -prices[0] 是直接定义第1天的状态数组
        }

        for (int i = 1; i < n; i++) {
            //正序和反序遍历k次交易是否有影响
            //要求证明
            //max(dp[i-1][j][1], **dp[i][j-1][0]** - prices[i])  等价于  max(dp[i-1][j][1], **dp[i-1][j-1][0]** - prices[i])
            //因为
            //**dp[i][j-1][0]** =max(dp[i-1][j-1][0],dp[i-1][j-1][1]+price[i])，则
            //左边= max(dp[i-1][j][1], **dp[i][j-1][0]** - prices[i])
            //=max(dp[i-1][j][1],max(dp[i-1][j-1][0],dp[i-1][j-1][1]+price[i])-price[i])
            //=max(dp[i-1][j][1]，dp[i-1][j-1][0]-price[i],dp[i-1][j-1][1]+price[i]-price[i])
            //=max(dp[i-1][j][1]，dp[i-1][j-1][0]-price[i],dp[i-1][j-1][1])
            //=max(dp[i-1][j][1]，dp[i-1][j-1][0]-price[i]) （因为dp[i-1][j-1][1]<=dp[i-1][j][1]恒成立）
            //=右边
            for (int j = k; j > 0; j--) {
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
            }
            //dp[i-1][j][1] >= dp[i-1][j-1][1]显然成立,这个是为什么?
            //同样的天数，最多允许j笔交易比起最多允许j-1笔，多了一笔，多一个可能性。所以如果你进行这笔操作，一定是赚更多；如果不进行，也能得到最多j-1时的答案。
        }
        //为什么是dp[k][1]?
        //这里dp数组状态定义是最多交易k次可以得到最高利润，dp方程也是基于此定义
        //所以dp[k][1]是比较包含0~k次中交易所能获的最高利润
        return dp[k][1];
    }

    public int unLimitPrices(int[] p) {
        int ans = 0;
        for (int i = 1; i < p.length; i++) {
            if (p[i] > p[i - 1]) {
                ans += p[i] - p[i - 1];
            }
        }
        return ans;
    }

}
