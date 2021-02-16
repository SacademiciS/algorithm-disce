package com.algorithm.disce.aunus;

public class One151 {
    public String reverseWords(String s) {
        String str = s.trim();
        char[] chars = str.toCharArray();
        int len = chars.length;
        int end = len - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = end; i > 0; i--) {
            if (chars[i] == ' ') {
                end--;
                continue;
            }
            if (chars[i - 1] == ' ') {
                sb.append(str.substring(i, end + 1)).append(" ");
                end = i - 1;
            }
        }
        sb.append(str.substring(0, end + 1));
        return sb.toString();
    }
}
