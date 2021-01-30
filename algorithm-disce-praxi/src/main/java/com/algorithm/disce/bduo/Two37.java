package com.algorithm.disce.bduo;

import java.util.Arrays;

public class Two37 {

    public void solveSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] box = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int t = board[i][j] - '0';
                    int mark = (i / 3) * 3 + j / 3;
                    rows[i] = stateAddition(rows[i], t);
                    cols[j] = stateAddition(cols[j], t);
                    box[mark] = stateAddition(box[mark], t);
                }
            }
        }

        dfs(rows, cols, box, 0, 0, board);
    }

    private boolean dfs(int[] rows, int[] cols, int[] box, int row, int col, char[][] board) {
        if (col == 9) {
            col = 0;
            row++;
            if (row == 9) {
                return true;
            }
        }

        if (board[row][col] == '.') {
            for (int i = 1; i <= 9; i++) {
                int mark = (row / 3) * 3 + col / 3;
                int rowT = rows[row];
                int colT = cols[col];
                int boxT = box[mark];

                if (check(rowT, i) || check(colT, i) || check(boxT, i)) {
                    continue;
                }

                board[row][col] = (char) ('0' + i);
                rows[row] = stateAddition(rowT, i);
                cols[col] = stateAddition(colT, i);
                box[mark] = stateAddition(boxT, i);

                if (dfs(rows, cols, box, row, col + 1, board)) {
                    return true;
                }

                board[row][col] = '.';
                rows[row] = rowT;
                cols[col] = colT;
                box[mark] = boxT;
            }
        } else {
            return dfs(rows, cols, box, row, col + 1, board);
        }
        return false;
    }

    private int stateAddition(int val, int n) {
        return val ^ (1 << n);
    }

    private boolean check(int val, int n) {
        return (val >> n & 1) == 1;
    }

    public static void main(String[] args) {
        Two37 o = new Two37();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        o.solveSudoku(board);
        System.out.println(Arrays.toString(board));
    }

}
