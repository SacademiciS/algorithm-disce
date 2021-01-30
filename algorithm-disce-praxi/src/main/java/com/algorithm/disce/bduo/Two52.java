package com.algorithm.disce.bduo;

public class Two52 {
    private int res;

    public int totalNQueens(int n) {
        int preHalf = 0;
        for (int i = 0; i < (n + 1) / 2; i++) {
            if (i == n / 2) preHalf = res;
            dfs(n, 1, 1 << i, 1 << (-i + n - 1), 1 << i);
        }
        return (n & 1) == 0 ? res * 2 : preHalf * 2 + (res - preHalf);
    }

    private void dfs(int n, int row, int col, int main, int sub) {
        if (row == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (((col >> i) & 1) == 0 && ((main >> (row - i + n - 1)) & 1) == 0 && ((sub >> (row + i)) & 1) == 0) {
                dfs(n, row + 1, col ^ (1 << i), main ^ (1 << (row - i + n - 1)), sub ^ (1 << (row + i)));
            }
        }
    }

    public static void main(String[] args) {
        Two52 t = new Two52();
        System.out.println(t.totalNQueens(4));
    }

}
