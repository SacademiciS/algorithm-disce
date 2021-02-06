package com.algorithm.disce.aunus;

public class One58 {

    public int lengthOfLastWord(String s) {
        char[] chars = s.trim().toCharArray();
        int index = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') index = i;
        }
        return index == -1 ? chars.length : chars.length - index - 1;
    }

    public static void main(String[] args) {
    }
}
