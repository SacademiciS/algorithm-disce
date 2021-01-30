package com.algorithm.disce.ctribus;

import java.util.ArrayList;
import java.util.List;

public class Three37 {

    private boolean[][] rows;
    private boolean[][] cols;
    private boolean[][][] boxUsed;
    private boolean valid = false;

    public void solveSudoku(char[][] board) {

        rows = new boolean[9][10];
        cols = new boolean[9][10];
        boxUsed = new boolean[3][3][10];
        //存储空白格位置集合,则不需要数独盘全部遍历一次
        List<int[]> spaceList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaceList.add(new int[]{i, j});
                } else {
                    rows[i][board[i][j] - '0'] = true;
                    cols[j][board[i][j] - '0'] = true;
                    boxUsed[i / 3][j / 3][board[i][j] - '0'] = true;
                }
            }
        }
        dfs(0, spaceList, board);
    }

    private void dfs(int n, List<int[]> spaceList, char[][] board) {
        if (n == spaceList.size()) {
            //递归结束标志,在遍历执行前需要判断
            //为什么需要标志校验？
            //因为即使当前递归结束，上层方法遍历还会执行下去，需要有东西通知上层已经处理完了
            valid = true;
            return;
        }
        int[] space = spaceList.get(n);
        int row = space[0];
        int col = space[1];
        for (int num = 0; num < 9 && !valid; num++) {
            if (!rows[row][num] && !cols[col][num] && !boxUsed[row / 3][col / 3][num]) {
                board[row][col] = (char) ('0' + num + 1);
                rows[row][num] = true;
                cols[col][num] = true;
                boxUsed[row / 3][col / 3][num] = true;
                dfs(n + 1, spaceList, board);
                //这里回溯不需要重新设置为'.',否则结果会变会初始请求用例,可以debug调试即可知道过程
                //理解：就算当前数值不正确，后续也会有新数值更新，不需要重新设置回'.'
                //board[row][col] = '.';
                rows[row][num] = false;
                cols[col][num] = false;
                boxUsed[row / 3][col / 3][num] = false;
            }
        }
    }

    public static void main(String[] args) {
        Three37 t = new Three37();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        t.solveSudoku(board);
    }

}
