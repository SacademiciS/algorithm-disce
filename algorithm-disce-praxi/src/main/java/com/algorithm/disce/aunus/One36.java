package com.algorithm.disce.aunus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class One36 {

    private Map<Integer, Set<Character>> row;
    private Map<Integer, Set<Character>> col;
    private Map<Integer, Set<Character>> area;

    //！！！注意：审题很关键
    public boolean isValidSudoku(char[][] board) {
        row = new HashMap<>();
        col = new HashMap<>();
        area = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            row.put(i, new HashSet<Character>());
            col.put(i, new HashSet<Character>());
            area.put(i, new HashSet<Character>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (row.get(i).contains(board[i][j]) || col.get(j).contains(board[i][j]) || area.get(countArea(i, j)).contains(board[i][j])) {
                    return false;
                }
                if (board[i][j] != '.') {
                    row.get(i).add(board[i][j]);
                    col.get(j).add(board[i][j]);
                    area.get(countArea(i, j)).add(board[i][j]);
                }
            }
        }

        return true;
    }

    private Integer countArea(int i, int j) {
        return (i / 3) * 3 + j / 3;
    }

}
