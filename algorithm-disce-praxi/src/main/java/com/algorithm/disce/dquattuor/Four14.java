package com.algorithm.disce.dquattuor;

public class Four14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int len = strs[0].length();
        int count = strs.length;

        //为什么是纵向扫描?
        for (int i = 0; i < len; i++) {
            //以第一个字符串为标准，取出第i列字符比较
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                //比较结束条件：
                //超出第j个字符串的长度（字符串长度不够了，说明最长只能到这里）
                //第j个字符串第i个字符不符合c,说明已经不是公共前缀了结束
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
