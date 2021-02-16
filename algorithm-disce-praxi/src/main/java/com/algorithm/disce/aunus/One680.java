package com.algorithm.disce.aunus;

public class One680 {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        return dfs(chars, 0, chars.length - 1, false);
    }

    private boolean dfs(char[] chars, int start, int end, boolean flag) {
        if (start > end) return true;
        if (chars[start] != chars[end]) {
            if (!flag) {
                return dfs(chars, start + 1, end, true) | dfs(chars, start, end - 1, true);
            }
            return false;
        }
        return dfs(chars, start + 1, end - 1, flag);
    }

    public static void main(String[] args) {
        One680 o = new One680();
        o.validPalindrome("abc");
    }
}
