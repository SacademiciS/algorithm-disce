package com.algorithm.disce.aunus;

public class One557 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        char[] chars = s.toCharArray();
        int start = chars.length - 1;
        int end = start;

        while (start >= 0) {
            while (start >= 0 && chars[start] != ' ') start--;
            reverseStr(chars, start + 1, end);
            end = --start;
        }

        return new String(chars);
    }

    private void reverseStr(char[] chars, int s, int e) {
        while (s < e) {
            char t = chars[s];
            chars[s] = chars[e];
            chars[e] = t;
            s++;
            e--;
        }
    }
}
