package com.algorithm.disce.bduo;

public class Two58 {

    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (end >= 0 && chars[end] == ' ') end--;
        int start = end;
        while (start >= 0 && chars[start] != ' ') start--;
        return end - start;
    }

}
