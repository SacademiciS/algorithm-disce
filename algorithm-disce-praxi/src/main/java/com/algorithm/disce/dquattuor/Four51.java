package com.algorithm.disce.dquattuor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four51 {


    public List<List<String>> solveNQueens(int n) {

        int[] queen = new int[n];
        Arrays.fill(queen, -1);
        List<List<String>> res = new ArrayList<>();
        dfs(queen, res, 0, 0, 0, 0, n);
        return res;
    }

    private void dfs(int[] queen, List<List<String>> res, int row, int col, int pie, int na, int n) {
        if (row == n) {
            List<String> broad = convert2Broad(queen, n);
            res.add(broad);
            return;
        }
        int availablePos = ((1 << n) - 1) & (~(col | pie | na));
        //x & (−x) 可以获得 xx 的二进制表示中的最低位的 1 的位置；
        //x & (x-1)可以将 x 的二进制表示中的最低位的 1 置成 0。

        while (availablePos != 0) {
            //填充完皇后的位置
            int pos = availablePos & (-availablePos);
            //
            availablePos = availablePos & (availablePos - 1);
            int column = Integer.bitCount(pos - 1);
            queen[row] = column;
            dfs(queen, res, row + 1, col | pos, (pie | pos) << 1, (na | pos) >> 1, n);
            queen[row] = -1;
        }
    }


    public List<String> convert2Broad(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        Four51 o = new Four51();
        o.solveNQueens(4);
    }

}
