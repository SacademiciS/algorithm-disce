package com.algorithm.disce.bduo;

public class Two14 {

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0) return "";

        String pre = strs[0];
        for (int j = 1; j < n; j++) {
            String str = strs[j];
            int end = 0;
            while (end < pre.length() && end < str.length() && pre.charAt(end) == str.charAt(end)) {
                end++;
            }
            pre = str.substring(0, end);
            if (pre.equals("")) return pre;
        }

        return pre;
    }

}
