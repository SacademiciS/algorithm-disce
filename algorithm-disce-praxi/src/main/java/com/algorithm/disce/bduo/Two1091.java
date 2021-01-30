package com.algorithm.disce.bduo;

import java.util.LinkedList;
import java.util.Queue;

public class Two1091 {

    private int[][] distance = {{0, 1}, {0, -1}, {1, -1}, {-1, -1}, {-1, 1}, {-1, 0}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        boolean[][] visited = new boolean[n][n];
        int[] init = {0, 0, 1};
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(init);
        while (!queue.isEmpty()) {
            int[] poll = queue.remove();
            int x = poll[0];
            int y = poll[1];
            if (x == n - 1 && y == n - 1) {
                return poll[2];
            }

            for (int i = 0; i < 8; i++) {
                int newX = x + distance[i][0];
                int newY = y + distance[i][1];
                if (isVail(newX, newY, n) && grid[newX][newY] == 0 && !visited[newX][newY]) {
                    int[] t = new int[]{newX, newY, poll[2] + 1};
                    visited[newX][newY] = true;
                    queue.add(t);
                }
            }
        }
        return -1;
    }

    private boolean isVail(int newX, int newY, int n) {
        return newX >= 0 && newX < n && newY >= 0 && newY < n;
    }

    public static void main(String[] args) {
        Two1091 t = new Two1091();
        int[][] grid = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(t.shortestPathBinaryMatrix(grid));
    }
}
