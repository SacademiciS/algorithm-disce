package com.algorithm.disce.dquattuor;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

public class Four_1091 {

    private int[][] distance = {{0, 1}, {0, -1}, {1, -1}, {-1, -1}, {-1, 1}, {-1, 0}, {1, 0}, {1, 1}};

    private int n;

    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if (n < 2) return n;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        //初始化关闭列表->我们已经访问了哪些节点？从起始节点到这个节点的最小step是多少？
        int[] closed = new int[n * n];
        Arrays.fill(closed, Integer.MAX_VALUE);
        pq.add(new Node(0, 0, 1));
        while (!pq.isEmpty()) {
            Node node = pq.remove();
            if (node.x == n - 1 && node.y == n - 1) {
                return node.step;
            }

            //如果具有相同位置的节点在关闭列表中
            //如果g小于或等于，跳过这个展开式
            if (closed[node.x * n + node.y] <= node.step) continue;
            //个人理解：closed数组最初全赋值int最大值,这里如果小于step说明这个点已经被走过了
            //而为什么要判断走过的点step小于当前step要跳过，因为当前题目是要寻找到终点最优值
            //而当前遍历到的点走的步数比之前的走到过步数更大，说明当前走法并不是最好的，直接忽略这种走法

            //在关闭列表上推送节点
            closed[node.x * n + node.y] = node.step;

            for (int i = 0; i < 8; i++) {
                int x = node.x + distance[i][0];
                int y = node.y + distance[i][1];
                if (isVail(x, y, n) && grid[x][y] == 0) {
                    pq.add(new Node(x, y, node.step + 1));
                }
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
        int step;
        int f;

        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.f = step + Math.max(n - 1 - x, n - 1 - y);
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
        Four_1091 f = new Four_1091();
        int[][] grid = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(f.shortestPathBinaryMatrix(grid));
    }
}
