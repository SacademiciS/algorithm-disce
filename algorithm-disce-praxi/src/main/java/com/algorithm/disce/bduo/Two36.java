package com.algorithm.disce.bduo;

public class Two36 {

    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] area = new int[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '0';
                    int areaMark = (i / 3) * 3 + j / 3;
                    if (row[i][index] == 1 || col[j][index] == 1 || area[areaMark][index] == 1) {
                        return false;
                    }
                    row[i][index] = 1;
                    col[j][index] = 1;
                    area[areaMark][index] = 1;
                }
            }
        }

        return true;
    }

}
