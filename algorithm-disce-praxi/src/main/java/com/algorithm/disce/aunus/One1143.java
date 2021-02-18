package com.algorithm.disce.aunus;

public class One1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        //状态定义 求text1字符串到第i个字符的字符串和text2到第j个字符的字符串最长公共子序列
        //状态数组 dp[i][j] i:0~text1.length() j:0~text2.length()
        //状态初始化 默认初始化0
        //dp方程（状态转移）
        //dp[i][j] = dp[i-1][j-1] + 1 (if text[i-1] == text2[j-1])
        //else dp[i][j] = max(dp[i-1][j],dp[i][j-1]);

        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
