package com.algorithm.disce.aunus;

public class One70 {

    public int climbStairs(int n) {
        if (n == 0) return 0;
        int pre = 1;
        int cur = 1;
        for (int i = 1; i < n; i++) {
            int tmp = pre + cur;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }

}
