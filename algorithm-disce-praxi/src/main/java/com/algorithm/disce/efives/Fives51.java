package com.algorithm.disce.efives;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fives51 {

    private int n;

    public List<List<String>> solveNQueens(int n) {
        int col = 0;
        int main = 0;
        int sub = 0;
        this.n = n;
        //设置棋盘数组
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chars[i], '.');
        }
        List<List<String>> res = new ArrayList<>();
        dfs(chars, 0, col, main, sub, res);
        return res;
    }

    private void dfs(char[][] chars, int row, int col, int main, int sub, List<List<String>> res) {

        if (row == n) {
            List<String> broad = convert2Broad(chars);
            res.add(broad);
            return;
        }

        for (int j = 0; j < chars.length; j++) {
            if (((col >> j) & 1) == 0 && ((main >> (row - j + n - 1)) & 1) == 0 && ((sub >> (row + j)) & 1) == 0) {
                //之前问题在于判断二进制数出现问题,不是 col>>j ==1 而是 (col >> j) & 1 是否为 1
                //原因在于只要判断 col 从右到左第 j 位二进制值下数值，而不是判断整个记录状态的int值是否为1(不符合逻辑)
                //if (!(col >> j == 1) && !(main >> (row - j + n - 1) == 1) && !(sub >> (row + j) == 1)) {
                chars[row][j] = 'Q';
                //这里可以直接填充参数进下一层，基本类型没有引用，不会随着下一层值变化而变化，所以状态记录不需要回溯
                dfs(chars, row + 1, col ^ (1 << j), main ^ (1 << (row - j + n - 1)), sub ^ (1 << (row + j)), res);
                chars[row][j] = '.';
            }

        }
    }

    private List<String> convert2Broad(char[][] chars) {
        List<String> broad = new ArrayList<>();
        for (char[] c : chars) {
            broad.add(new String(c));
        }
        return broad;
    }

}
