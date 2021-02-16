package com.algorithm.disce.dquattuor;

public class Four37 {

    public void solveSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] box = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int mark = (i / 3) * 3 + j / 3;
                    row[i] = stateAddition(row[i], num);
                    col[j] = stateAddition(col[j], num);
                    box[mark] = stateAddition(box[mark], num);
                }
            }
        }

        dfs(row, col, box, 0, 0, board);
    }

    private boolean dfs(int[] rows, int[] cols, int[] box, int x, int y, char[][] board) {
        if (y == 9) {
            y = 0;
            x++;
            if (x == 9) {
                return true;
            }

        }

        if (board[x][y] == '.') {
            for (int i = 1; i <= 9; i++) {
                int mark = (x / 3) * 3 + y / 3;
                int rowT = rows[x];
                int colT = cols[y];
                int boxT = box[mark];

                if (check(rowT, i) || check(colT, i) || check(boxT, i)) {
                    continue;
                }

                board[x][y] = (char) ('0' + i);
                rows[x] ^= (1 << i);
                cols[y] ^= (1 << i);
                box[mark] ^= (1 << i);

                if (dfs(rows, cols, box, x, y + 1, board)) {
                    return true;
                }

                board[x][y] = '.';
                rows[x] = rowT;
                cols[y] = colT;
                box[mark] = boxT;
            }
        } else {
            return dfs(rows, cols, box, x, y + 1, board);
        }

        return false;
    }

    private int stateAddition(int val, int n) {
        return val ^ (1 << n);
    }

    private boolean check(int val, int n) {
        return (val >> n & 1) == 1;
    }

}
