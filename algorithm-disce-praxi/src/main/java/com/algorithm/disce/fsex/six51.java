package com.algorithm.disce.fsex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class six51 {

    public List<List<String>> solveNQueens(int n) {
        char[][] record = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(record[i], '.');
        }
        List<List<String>> res = new ArrayList<>();
        dfs(n, 0, 0, 0, 0, record, res);
        return res;
    }

    private void dfs(int n, int row, int col, int pie, int na, char[][] record, List<List<String>> res) {
        if (row == n) {
            List<String> broad = convert2Broad(record);
            res.add(broad);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (checkPlace(col, i) && checkPlace(pie, row - i + n - 1) && checkPlace(na, row + i)) {
                record[row][i] = 'Q';
                dfs(n, row + 1, col ^ (1 << i), pie ^ (1 << (row - i + n - 1)), na ^ (1 << (row + i)), record, res);
                record[row][i] = '.';
            }
        }
    }

    private boolean checkPlace(int value, int num) {
        return ((value >> num) & 1) == 0;
    }

    private List<String> convert2Broad(char[][] record) {
        List<String> broad = new ArrayList<>();
        for (char[] chars : record) {
            broad.add(new String(chars));
        }
        return broad;
    }
}
