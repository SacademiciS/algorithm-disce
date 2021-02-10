package com.algorithm.disce.bduo;


public class Two8 {

    public int myAtoi(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int start = 0;
        while (start < n && chars[start] == ' ') start++;
        if (start == n) return 0;

        int symbol = 1;
        if (chars[start] == '-') {
            symbol = -1;
            start++;
        } else if (chars[start] == '+') {
            start++;
        }

        int end = start;
        while (end < n && chars[end] >= '0' && chars[end] <= '9') end++;
        int res = 0;
        for (int i = start; i < end; i++) {
            int digit = chars[i] - '0';
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return symbol == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
        }
        return symbol == 1 ? res : -res;
    }

}
