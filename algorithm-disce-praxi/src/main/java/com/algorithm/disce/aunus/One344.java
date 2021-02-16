package com.algorithm.disce.aunus;

public class One344 {

    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }

}
