package com.algorithm.disce.aunus;

public class One5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        //状态定义 求s.i~s.j之间存在最大回文子串
        //状态数组 dp[i][j]
        //dp方程 dp[i][j] = s[i] == s[j] && dp[i-1][j-1]
        //说明：
        //「动态规划」事实上是在填一张二维表格，由于构成子串，因此 i 和 j 的关系是 i <= j ，因此，只需要填这张表格对角线以上的部分。
        //！！看到 dp[i + 1][j - 1] 就得考虑边界情况。
        //边界条件是：表达式 [i + 1, j - 1] 不构成区间，即长度严格小于 2，即 j - 1 - (i + 1) + 1 < 2 ，整理得 j - i < 3
        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();
        int maxLength = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }
}
