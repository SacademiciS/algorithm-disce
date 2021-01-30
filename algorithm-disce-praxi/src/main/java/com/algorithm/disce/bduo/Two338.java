package com.algorithm.disce.bduo;

public class Two338 {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        //子问题 求数字i计算其二进制数中的 1 的数目
        //状态数组 dp[i]
        //状态定义 数字i的二进制数中的 1 的数目
        // dp方程 dp[i] = dp[i>>1] + (i&1)
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

}
