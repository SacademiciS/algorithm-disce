package com.algorithm.disce.aunus;

class One541 {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 || k == 1) return s;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            if (i + k < chars.length) {
                dfs(chars, i, i + k - 1);
            } else {
                dfs(chars, i, chars.length - 1);
            }
        }
        return new String(chars);
    }

    private void dfs(char[] chars, int start, int end) {
        if (start > end) return;

        char t = chars[start];
        chars[start] = chars[end];
        chars[end] = t;
        dfs(chars, start + 1, end - 1);
    }
}
