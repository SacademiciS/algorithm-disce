package com.algorithm.disce.aunus;

public class One8 {

    public int myAtoi(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int start = 0;
        int symbol = 1;
        while (start < n && chars[start] == ' ') start++;
        if (start == n) return 0;
        if (chars[start] == '-') {
            symbol = -1;
            start++;
        } else if (chars[start] == '+') {
            start++;
        }
        int end = start;
        while (end < s.length() && chars[end] >= '0' && chars[end] <= '9') end++;
        String num = s.substring(start, end);
        return convertToInt(symbol, num);
    }

    private int convertToInt(int symbol, String num) {
        int n = num.length();
        if (n == 0) return 0;
        long res = 0;
        char[] chars = num.toCharArray();
        for (int i = 0; i < n; i++) {
            res = res * 10 + chars[i] - '0';
            if (symbol * res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
                return symbol < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return (int) (symbol * res);
    }

    public static void main(String[] args) {
        One8 o = new One8();
        System.out.println(o.myAtoi(" "));
    }

}
