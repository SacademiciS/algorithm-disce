package com.algorithm.disce.ctribus;

public class Three714 {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int pre = -prices[0] - fee;
        int cur = 0;

        for (int i = 1; i < n; i++) {
            pre = Math.max(pre, cur - prices[i] - fee);
            cur = Math.max(cur, pre + prices[i]);
        }

        return cur;
    }

    public static void main(String[] args) {
        Three714 t = new Three714();
        int[] p = {1, 3, 2, 8, 4, 9};
        t.maxProfit(p, 2);
    }

}
