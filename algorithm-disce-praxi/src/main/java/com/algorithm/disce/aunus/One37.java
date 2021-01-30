package com.algorithm.disce.aunus;

import java.util.Arrays;

public class One37 {

    private boolean[][] rows;
    private boolean[][] cols;
    private boolean[][][] boxUsed;

    public void solveSudoku(char[][] board) {

        rows = new boolean[9][10];
        cols = new boolean[9][10];
        boxUsed = new boolean[3][3][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '0';
                    rows[i][index] = true;
                    cols[j][index] = true;
                    boxUsed[i / 3][j / 3][index] = true;
                }
            }
        }

        dfs(0, 0, board);
    }

    private boolean dfs(int row, int col, char[][] board) {
        if (col == 9) {
            col = 0;
            row++;
            if (row == 9) {
                return true;
            }
        }

        if (board[row][col] == '.') {
            // 尝试填充1~9
            for (int num = 1; num <= 9; num++) {
                if (rows[row][num] || cols[col][num] || boxUsed[row / 3][col / 3][num]) {
                    continue;
                }

                board[row][col] = (char) ('0' + num);
                rows[row][num] = true;
                cols[col][num] = true;
                boxUsed[row / 3][col / 3][num] = true;

                if (dfs(row, col + 1, board)) {
                    return true;
                }
                board[row][col] = '.';
                rows[row][num] = false;
                cols[col][num] = false;
                boxUsed[row / 3][col / 3][num] = false;
            }
        } else {
            return  dfs(row, col + 1, board);
        }
        return false;
    }

    public static void main(String[] args) {
        One37 o = new One37();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        o.solveSudoku(board);
        System.out.println(Arrays.toString(board));
    }

}
