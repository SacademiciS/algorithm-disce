package com.algorithm.disce.bduo;

public class Two1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        //状态定义 求 text1[0..i]字符串 和 text2[0..j]字符串 最长公共子序列的长度
        //状态数组 dp[i][j]
        //dp方程
        // dp[i][j] = dp[i-1][j-1] + 1 (if text1[i-1] == text2[j-1])
        // else dp[i][j] = max(dp[i-1][j],dp[i][j-1])
        //初始化 dp[0..i][0] = 0, dp[0][0..j] = 0
        int len1 = text1.length();
        int len2 = text2.length();

        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();

        int[] dp = new int[len2 + 1];


        for (int i = 1; i <= len1; i++) {
            int last = 0;
            for (int j = 1; j <= len2; j++) {
                int temp = dp[j];
                if (c1[i - 1] == c2[j - 1]) {
                    dp[j] = last + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                last = temp;
            }
        }
        return dp[len2];
    }
}
