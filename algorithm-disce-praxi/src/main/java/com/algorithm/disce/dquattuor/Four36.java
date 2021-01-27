package com.algorithm.disce.dquattuor;

/**
 * @Author: wjh
 * @Description
 * @Date: 2021/1/27 11:58
 * Copyright (c) 2019 北京新媒传信科技有限公司
 */
public class Four36 {

    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] box = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int index = (i / 3) * 3 + j / 3;
                    if (((rows[i] >> num) & 1) == 0 && ((cols[j] >> num) & 1) == 0 && ((box[index] >> num) & 1) == 0) {
                        rows[i] ^= (1 << num);
                        cols[j] ^= (1 << num);
                        box[index] ^= (1 << num);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] g = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {
                '.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {
                '4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {
                '.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {
                '.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Four36 f = new Four36();
        System.out.println(f.isValidSudoku(g));
    }

}
