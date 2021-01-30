package com.algorithm.disce.aunus;

public class One52 {

    private int count = 0;

    public int totalNQueens(int n) {
        dfs(n, 0, 0, 0, 0);
        return count;
    }

    private void dfs(int n, int row, int col, int main, int sub) {
        if (row == n) {
            count += 1;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (((col >> i) & 1) == 0 && ((main >> (row - i + n - 1)) & 1) == 0 && ((sub >> (row + i)) & 1) == 0) {
                dfs(n, row + 1, col ^ (1 << i), main ^ (1 << (row - i + n - 1)), sub ^ (1 << (row + i)));
            }
        }
    }
}
