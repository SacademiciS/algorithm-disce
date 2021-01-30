package com.algorithm.disce.ctribus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three51 {

    private int n;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) return res;
        char[][] chars = new char[n][n];
        this.n = n;
        for (int i = 0; i < n; i++) {
            Arrays.fill(chars[i], '.');
        }
        dfs(chars, 0, n, res);
        return res;
    }

    private void dfs(char[][] chars, int row, int n, List<List<String>> res) {
        if (row == n) {
            List<String> broad = convert2Broad(chars);
            res.add(broad);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isVail(chars, row, j)) {
                chars[row][j] = 'Q';
                dfs(chars, row + 1, n, res);
                chars[row][j] = '.';
            }
        }
    }

    private boolean isVail(char[][] chars, int row, int col) {
        for (int i = 0; i < n; i++) {
            if (chars[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> convert2Broad(char[][] chars) {
        List<String> broad = new ArrayList<>();
        for (char[] c : chars) {
            broad.add(new String(c));
        }
        return broad;
    }

}
