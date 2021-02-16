package com.algorithm.disce.bduo;

public class Two125 {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            if (Character.isLetterOrDigit(c)) {
                str.append(Character.toLowerCase(c));
            }
        }
        char[] chars = str.toString().toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) return false;
        }
        return true;
    }
}
