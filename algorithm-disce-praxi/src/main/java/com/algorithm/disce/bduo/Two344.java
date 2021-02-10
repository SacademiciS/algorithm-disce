package com.algorithm.disce.bduo;

public class Two344 {

    public void reverseString(char[] s) {
        dfs(0, s.length - 1, s);
    }

    private void dfs(int start, int end, char[] s) {
        if (start > end) {
            return;
        }

        char t = s[start];
        s[start] = s[end];
        s[end] = t;
        dfs(start + 1, end - 1, s);
    }

}
