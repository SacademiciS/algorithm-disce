package com.algorithm.disce.ctribus;


public class Three52 {

    private int count;

    public int totalNQueens(int n) {
        dfs(n, 0, 0, 0, 0);
        return count;
    }

    private void dfs(int n, int row, int col, int pie, int na) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isUnOccupy(col, i) && isUnOccupy(pie, row - i + n - 1) && isUnOccupy(na, row + i)) {
                dfs(n, row + 1, col ^ (1 << i), pie ^ (1 << (row - i + n - 1)), na ^ (1 << (row + i)));
            }
        }
    }

    private boolean isUnOccupy(int value, int num) {
        return ((value >> num) & 1) == 0;
    }

}
