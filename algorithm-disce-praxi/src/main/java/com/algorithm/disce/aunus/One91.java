package com.algorithm.disce.aunus;

public class One91 {
    public int numDecodings(String s) {
        //子问题 求最后一个字符到第i个字符能解码方法的总数
        //状态数组 dp[i]
        //状态定义 最后一个字符到第i个字符能解码方法的总数
        //dp方程
        // if 10<= s[i..i+1] <= 26
        // dp[i] = dp[i+1] + dp[i+2]

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        if (s.charAt(n - 1) != '0') {
            dp[n - 1] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i + 1];
            }
            int t = 10 * (s.charAt(i) - '0') + s.charAt(i + 1) - '0';
            if (t >= 10 && t <= 26) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        One91 o = new One91();
        o.numDecodings("12");
    }
}
