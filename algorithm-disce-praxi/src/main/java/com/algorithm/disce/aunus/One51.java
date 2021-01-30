package com.algorithm.disce.aunus;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class One51 {

    private int n;

    private boolean[] col;
    //记录副对角线的单元格是否放置了皇后
    private boolean[] main;
    //记录主对角线上的单元格是否放置了皇后
    private boolean[] sub;

    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if (n == 0) return res;

        this.n = n;
        this.col = new boolean[n];
        this.main = new boolean[2 * n - 1];
        this.sub = new boolean[2 * n - 1];
        ArrayDeque<Integer> path = new ArrayDeque<>();
        dfs(0, path);
        return res;
    }

    private void dfs(int row, ArrayDeque<Integer> path) {
        if (row == n) {
            // 深度优先遍历到下标为 n，表示 [0.. n - 1] 已经填完，得到了一个结果
            List<String> board = convert2Board(path);
            res.add(board);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!col[j] && !main[row - j + n - 1] && !sub[row + j]) {
                path.addLast(j);
                col[j] = true;
                main[row - j + n - 1] = true;
                sub[row + j] = true;

                dfs(row + 1, path);
                sub[row + j] = false;
                main[row - j + n - 1] = false;
                col[j] = false;
                path.removeLast();
            }
        }

    }

    private List<String> convert2Board(ArrayDeque<Integer> path) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            char[] c = new char[n];
            for (int i = 0; i < n; i++) {
                if (i != num) {
                    c[i] = '.';
                } else {
                    c[i] = 'Q';
                }
            }
            board.add(new String(c));
        }
        return board;
    }

    public static void main(String[] args) {
        One51 o = new One51();
        o.solveNQueens(4);
    }

}
