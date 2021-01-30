package com.algorithm.disce.aunus;

import java.util.LinkedList;
import java.util.Queue;

public class One1091 {

    private static int[][] directions = {{0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) return -1;
        grid[0][0] = 1;
        Queue<int[]> pos = new LinkedList<>();
        pos.add(new int[]{0, 0});
        while (!pos.isEmpty() && grid[row - 1][col - 1] == 0) {
            int[] xy = pos.remove();
            int preLength = grid[xy[0]][xy[1]];
            for (int i = 0; i < 8; i++) {
                int newX = xy[0] + directions[i][0];
                int newY = xy[1] + directions[i][1];
                if (isVail(newX, newY, row, col) && grid[newX][newY] == 0) {
                    pos.add(new int[]{newX, newY});
                    grid[newX][newY] = preLength + 1;
                }
            }
        }
        return grid[row - 1][col - 1] == 0 ? -1 : grid[row - 1][col - 1];
    }

    private boolean isVail(int newX, int newY, int row, int col) {
        return newX >= 0 && newX < row && newY >= 0 && newY < col;
    }

//    private int dfs(int[][] grid, int n, int i, int j, int count) {
//        if (i == n - 1 && j == n - 1) {
//            return count;
//        }
//
//        int p1 = Integer.MAX_VALUE;
//        int p2 = Integer.MAX_VALUE;
//        int p3 = Integer.MAX_VALUE;
//
//        if (i != n - 1 && j != n - 1 && grid[i + 1][j + 1] != 1) {
//            p1 = dfs(grid, n, i + 1, j + 1, count + 1);
//        }
//
//        if (i != n - 1 && grid[i + 1][j] != 1) {
//            p2 = dfs(grid, n, i + 1, j, count + 1);
//        }
//
//        if (j != n - 1 && grid[i][j + 1] != 1) {
//            p3 = dfs(grid, n, i, j + 1, count + 1);
//        }
//
//        return Math.min(p1, Math.min(p2, p3));
//    }

    public static void main(String[] args) {
        One1091 o = new One1091();
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 0, 0}, {0, 0, 0, 1, 1, 1, 0}, {1, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 0, 1}, {0, 0, 1, 0, 0, 0, 0}};
        System.out.println(o.shortestPathBinaryMatrix(grid));
    }
}
