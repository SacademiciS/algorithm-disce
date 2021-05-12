package com.algorithm.disce.bduo;

public class Two72 {
    public int minDistance(String word1, String word2) {
        //状态定义 求 word1[0..i] （到第i个字符的字符串）转换成 word2[0..j] 所使用的最少操作数
        //状态数组 dp[i][j]
        //dp方程
        //dp[i][j] = dp[i-1][j-1] (if word1[i] == word2[j])
        //else dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]) + 1
        //初始化 dp[0..i][0] = 0..i ; dp[0][0..j] = 0..j
        //虽然dp是二维数组，但我们计算的时候每个元素只和他的左边，上边，左上角的3个值有关，所以这里我们还可以优化一下，使用一维数组
        int len1 = word1.length();
        int len2 = word2.length();

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        int[] dp = new int[len2 + 1];
        for (int i = 0; i <= len2; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= len1; i++) {
            //！！注意：这里一定要先把 dp[0] 赋值给 last
            //在dp[0]=i 前，这里的dp[0]还相当于上一层的dp[i-1][0],last要记录用于下面状态传递进行比较
            int last = dp[0];
            // 为什么要设置 dp[0] = i？
            // 因为优化一维数组空间后，dp[0..j]无法一开始进行初始化了，故只能在外层循环起始进行初始化
            dp[0] = i;
            for (int j = 1; j <= len2; j++) {
                int temp = dp[j];
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[j] = last;
                } else {
                    //！！解释：这里进行空间优化后数值解释
                    //dp[j-1] = dp[i][j-1]
                    //dp[j] = dp[i-1][j]
                    //last = dp[i-1][j-1]
                    dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), last) + 1;
                }
                last = temp;
            }
        }

        return dp[len2];
    }

    public static void main(String[] args) {
        Two72 t = new Two72();
        System.out.println(t.minDistance("horse", "ros"));
    }
}
