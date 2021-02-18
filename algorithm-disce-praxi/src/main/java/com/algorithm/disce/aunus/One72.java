package com.algorithm.disce.aunus;

public class One72 {
    public int minDistance(String word1, String word2) {
        //状态定义 求word1字符串到第i个字符的字符串转换word2到第j个字符的字符串最少操作数
        //状态数组 dp[i][j] i:0~word1.length()+1 j:0~word2.length()+1
        //状态初始化 dp[i..][0] = i.. dp[0][j..] = j..
        //！！注意，针对第一行，第一列要单独考虑，我们引入 '' 下图所示：
        //第一行，是 word1 为空变成 word2 最少步数，就是插入操作
        //第一列，是 word2 为空，需要的最少步数，就是删除操作
        //dp方程
        // dp[i][j] = dp[i-1][j-1] if(word1[i-1] == word2[j-1])
        // else min(dp[i-1][j-1] + 1, dp[i-1][j] + 1, dp[i][j-1] + 1)

        //对“dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。”的补充理解
        //以 word1 为 "horse"，word2 为 "ros"，且 dp[5][3] 为例，即要将 word1的前 5 个字符转换为 word2的前 3 个字符，也就是将 horse 转换为 ros，因此有：
        //(1) dp[i-1][j-1]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 2 个字符 ro，然后将第五个字符 word1[4]（因为下标基数以 0 开始） 由 e 替换为 s（即替换为 word2 的第三个字符，word2[2]）
        //(2) dp[i][j-1]，即先将 word1 的前 5 个字符 horse 转换为 word2 的前 2 个字符 ro，然后在末尾补充一个 s，即插入操作
        //(3) dp[i-1][j]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 3 个字符 ros，然后删除 word1 的第 5 个字符
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[len1][len2];
    }
}
