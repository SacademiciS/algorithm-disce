package com.algorithm.disce.ctribus;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class Three1091 {

    private int n;

    private int[][] distance = {{0, 1}, {0, -1}, {1, -1}, {-1, -1}, {-1, 1}, {-1, 0}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if (n == 1) return 1;
        int[][] dir = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},
                {-1, 1}, {-1, -1}, {1, -1}, {1, 1}
        };
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0, 0, grid[0][0] = 1));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int step = grid[node.x][node.y];
            for (int[] d : dir) {
                int x = node.x + d[0];
                int y = node.y + d[1];
                if (x == n - 1 && y == n - 1) return step + 1;
                if (!isVail(x, y, n)) continue;
                //为什么要判断走过的点step小于当前step要跳过，因为当前题目是要寻找到终点最优值
                //而当前遍历到的点走的步数比之前的走到过步数更大，说明当前走法并不是最好的，直接忽略这种走法
                if (grid[x][y] != 0 && grid[x][y] <= step + 1) continue;
                Node next = new Node(x, y, grid[x][y] = step + 1);
                queue.offer(next);
            }
        }

        return -1;
    }

    private boolean isVail(int newX, int newY, int n) {
        return newX >= 0 && newX < n && newY >= 0 && newY < n;
    }

    class Node implements Comparable<Node> {
        int x;
        int y;
        int f;

        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            int distance = Math.max(n - 1 - x, n - 1 - y);
            this.f = distance + step;
        }

        @Override
        public int compareTo(Node o) {
            return this.f - o.f;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        Three1091 t = new Three1091();
        int[][] grid = {{0, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {1, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0}};
        //int[][] grid = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(t.shortestPathBinaryMatrix(grid));
    }
}
