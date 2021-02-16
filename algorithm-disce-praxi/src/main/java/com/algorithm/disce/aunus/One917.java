package com.algorithm.disce.aunus;


public class One917 {

    public String reverseOnlyLetters(String S) {
        int start = 0;
        int end = S.length() - 1;
        char[] chars = S.toCharArray();
        while (start < end) {
            if (Character.isLetter(chars[start]) && Character.isLetter(chars[end])) {
                char t = chars[start];
                chars[start] = chars[end];
                chars[end] = t;
                start++;
                end--;
            } else if (Character.isLetter(chars[start])) {
                end--;
            } else if (Character.isLetter(chars[end])) {
                start++;
            } else {
                start++;
                end--;
            }
        }

        return new String(chars);
    }

}
