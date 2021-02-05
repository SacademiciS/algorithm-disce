package com.algorithm.disce.efives;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wjh
 * @Description
 * @Date: 2021/2/5 16:24
 * Copyright (c) 2019 北京新媒传信科技有限公司
 */
public class Fives37 {

    private int[] rows;
    private int[] cols;
    private int[][] box;
    private boolean valid = false;

    public void solveSudoku(char[][] board) {
        rows = new int[9];
        cols = new int[9];
        box = new int[3][3];
        List<int[]> spaceList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaceList.add(new int[]{i, j});
                } else {
                    int num = board[i][j] - '0';
                    rows[i] ^= (1 << num);
                    cols[j] ^= (1 << num);
                    box[i / 3][j / 3] ^= (1 << num);
                }
            }
        }

        dfs(0, spaceList, board);
    }

    private void dfs(int index, List<int[]> spaceList, char[][] board) {
        if (index == spaceList.size()) {
            valid = true;
            return;
        }

        int[] space = spaceList.get(index);
        int row = space[0];
        int col = space[1];
        for (int i = 1; i <= 9 && !valid; i++) {
            if (check(rows[row], i) || check(cols[col], i) || check(box[row / 3][col / 3], i)) {
                continue;
            }
            rows[row] = stateAddition(rows[row], i);
            cols[col] = stateAddition(cols[col], i);
            box[row / 3][col / 3] = stateAddition(box[row / 3][col / 3], i);
            board[row][col] = (char) ('0' + i);
            dfs(index + 1, spaceList, board);
            rows[row] = stateAddition(rows[row], i);
            cols[col] = stateAddition(cols[col], i);
            box[row / 3][col / 3] = stateAddition(box[row / 3][col / 3], i);
        }
    }

    private int stateAddition(int val, int n) {
        return val ^ (1 << n);
    }

    private boolean check(int val, int n) {
        return (val >> n & 1) == 1;
    }
}
