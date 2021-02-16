package com.algorithm.disce.bduo;

public class Two680 {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (chars[start] == chars[end]) {
                start++;
                end--;
            } else {
                break;
            }
        }

        return isVailPalindrome(chars, start + 1, end) | isVailPalindrome(chars, start, end - 1);
    }

    private boolean isVailPalindrome(char[] chars, int start, int end) {
        for (int i = start; i < end; i++, end--) {
            if (chars[i] != chars[end]) return false;
        }
        return true;
    }
}
